package programmers_level3;

import java.util.*;

public class Test7 {
    public static void main(String[] args) {
        int k = 3;
        int n = 5;
        int[][] reqs1 = {{10, 60, 1}, {15, 100, 3}, {20, 30, 1}, {30, 50, 3}, {50, 40, 1}, {60, 30, 2}, {65, 30, 1}, {70, 100, 2}};
        int[][] reqs2 = {{5, 55, 2}, {10, 90, 2}, {20, 40, 2}, {50, 45, 2}, {100, 50, 2}};
        System.out.println(solution(k, n, reqs1));
    }

    public static int solution(int k, int n, int[][] reqs) {
        HashMap<Integer, Node7> map = new HashMap();
        Queue<HashMap<Integer, Node7>> queue = new LinkedList<>();
        Queue<int[]> mentor = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            map.put(i + 1, new Node7(0));
        }

        queue.add(new HashMap<>(map));

        int[] men = new int[k];
        Arrays.fill(men, n-k);
        mentor.add(men);

        for (int[] req : reqs) {
            int requestStartTime = req[0];
            int requestTakeTime = req[1];
            int requestType = req[2];

            Queue<HashMap<Integer, Node7>> tempQueue = new LinkedList<>();

            while (!queue.isEmpty()) {
                HashMap<Integer, Node7> polledMap = queue.poll(); //큐에서 맵을 하나 뽑음
                int[] leftMentor = mentor.poll(); //남은 맨토 수 뽑음

                int enableNextInterviewTime = polledMap.get(requestType).queue.peek(); //다음 시작가능 시간

                //요청시작시간이 다음 시작가능시간 이후면
                if(enableNextInterviewTime <= requestStartTime) {
                    HashMap<Integer, Node7> copiedMap = new HashMap<>();
                    for(Map.Entry<Integer, Node7> entry : polledMap.entrySet()) {
                        copiedMap.put(entry.getKey(), new Node7(entry.getValue()));
                    }
                    copiedMap.get(requestType).queue.poll(); //기존에 있던 다음시작가능시간은 제거하고
                    copiedMap.get(requestType).queue.add(requestStartTime + requestTakeTime); //갱신
                    mentor.add(leftMentor); //맨토는 다시 넣어주고
                    tempQueue.add(copiedMap);
                } else { //요청시작시간이 다음 시작가능시간 이전이면
                    if(leftMentor[requestType-1] > 0) { //남은 맨토가 있는 경우
                        HashMap<Integer, Node7> copiedMap = new HashMap<>();
                        for(Map.Entry<Integer, Node7> entry : polledMap.entrySet()) {
                            copiedMap.put(entry.getKey(), new Node7(entry.getValue()));
                        }
                        copiedMap.get(requestType).queue.add(requestStartTime + requestTakeTime);
                        int[] leftMentor2 = new int[k];
                        for(int i = 0; i < k; i++) {
                            leftMentor2[i] = leftMentor[i] - 1;
                        }
                        mentor.add(leftMentor2);
                        tempQueue.add(copiedMap);

                        copiedMap = new HashMap<>();
                        for(Map.Entry<Integer, Node7> entry : polledMap.entrySet()) {
                            copiedMap.put(entry.getKey(), new Node7(entry.getValue()));
                        }
                        copiedMap.get(requestType).queue.poll();
                        copiedMap.get(requestType).queue.add(enableNextInterviewTime + requestTakeTime);
                        copiedMap.get(requestType).waiting += (enableNextInterviewTime - requestStartTime);
                        int[] leftMentor3 = leftMentor.clone();
                        leftMentor3[requestType-1] -= 1;
                        mentor.add(leftMentor3);
                        tempQueue.add(copiedMap);
                    } else {
                        HashMap<Integer, Node7> copiedMap = new HashMap<>();
                        for(Map.Entry<Integer, Node7> entry : polledMap.entrySet()) {
                            copiedMap.put(entry.getKey(), new Node7(entry.getValue()));
                        }
                        copiedMap.get(requestType).queue.poll();
                        copiedMap.get(requestType).queue.add(enableNextInterviewTime + requestTakeTime);
                        copiedMap.get(requestType).waiting += (enableNextInterviewTime - requestStartTime);
                        mentor.add(leftMentor);
                        tempQueue.add(copiedMap);
                    }
                }
            }
            queue = tempQueue;
        }

        int min = Integer.MAX_VALUE;

        while(!queue.isEmpty()) {
            int sum = 0;
            HashMap<Integer, Node7> temp = queue.poll();
            for(Node7 node7 : temp.values()) {
                sum += node7.waiting;
            }
            min = Math.min(min, sum);
        }

        return min;
    }
}

class Node7 {
    int waiting;
    PriorityQueue<Integer> queue = new PriorityQueue<>(); //종료시간

    Node7(int waiting) {
        this.waiting = waiting;
        this.queue.add(0);
    }

    Node7(Node7 other) {
        this.waiting = other.waiting;
        this.queue = new PriorityQueue<>(other.queue);
    }
}
