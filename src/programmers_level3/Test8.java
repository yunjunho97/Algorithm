package programmers_level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Test8 {
    static ArrayList<int[]> staticList = new ArrayList<>();
    public static void main(String[] args) {
        int k = 2;
        int n = 3;
        int[][] reqs1 = {{10, 60, 1}, {15, 100, 3}, {20, 30, 1}, {30, 50, 3}, {50, 40, 1}, {60, 30, 2}, {65, 30, 1}, {70, 100, 2}};
        int[][] reqs2 = {{5, 55, 2}, {10, 90, 2}, {20, 40, 2}, {50, 45, 2}, {100, 50, 2}};
        System.out.println(solution(k, n, reqs2));
    }

    public static int solution(int k, int n, int[][] reqs) {
        //요청 타입별로 분리
        HashMap<Integer, ArrayList<int[]>> types = new HashMap<>();
        for(int i = 0; i < k; i++) {
            types.put(i+1, new ArrayList<>());
        }
        for(int[] req : reqs) {
            types.get(req[2]).add(new int[]{req[0], req[1]});
        }

        int maxEnableMentor = n - k + 1; //한 타입에 최대로 들어갈수있는 맨토수

        ArrayList<int[]> enableWaitingTimesList = new ArrayList<>();
        //{ {1번타입 1명~n명}, {}, {} }

        //i+1타입에서 j+1명의 맨토가 배치되었을때 대기시간
        for(ArrayList<int[]> type : types.values()) {
            enableWaitingTimesList.add(enableWaitingTimes(maxEnableMentor, type));
        }

        //가능한 맨토 배치 조합 구성
        int[] init = new int[k];
        Arrays.fill(init, 1);
        recursive(0, 0, maxEnableMentor-1, init);

        int min = Integer.MAX_VALUE;
        for(int[] enableMentorsArr : staticList) {
            //{4, 1, 1}
            int sum = 0;
            for(int i = 0; i < enableMentorsArr.length; i++) {
                sum += enableWaitingTimesList.get(i)[enableMentorsArr[i]-1];
            }
            min = Math.min(min, sum);
        }

        return min;
    }

    public static int[] enableWaitingTimes(int maxEnableMentor, ArrayList<int[]> list) {
        int[] waitingTimeByMentorsNumber = new int[maxEnableMentor];
        for(int i = 1; i <= maxEnableMentor; i++) {
            int totalWaitingTime = 0;
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            queue.add(0);
            for(int[] request : list) {
                //큐에서 꺼낸 값이 요청시작시간보다 빨리 끝나면
                if(queue.peek() < request[0]) {
                    queue.poll();
                    queue.add(request[0] + request[1]);
                } else { //큐에서 꺼낸 값이 요청시작시간보다 늦게 끝나면
                    if(queue.size() < i) { //여유인원이 있을 경우
                        queue.add(request[0] + request[1]);
                    } else { //여유인원이 없을경우
                        int enableStartTime = queue.poll();
                        queue.add(enableStartTime + request[1]);
                        totalWaitingTime += enableStartTime - request[0];
                    }
                }
            }
            waitingTimeByMentorsNumber[i-1] = totalWaitingTime;
        }
        return waitingTimeByMentorsNumber;
    }

    public static void recursive(int l, int count, int maxEnableMentor, int[] arr) {
        if(count == maxEnableMentor) {
            staticList.add(arr.clone());
            return;
        }

        if(l == arr.length) return;

        arr[l] += 1;
        recursive(l, count+1, maxEnableMentor, arr);
        arr[l] -= 1;
        recursive(l+1, count, maxEnableMentor, arr);
    }
}
