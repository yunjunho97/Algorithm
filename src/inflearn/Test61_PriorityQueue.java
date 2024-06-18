package inflearn;

import java.util.*;

public class Test61_PriorityQueue {
    public static void main(String[] args) {
        ArrayList<Integer[]> list = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            list.add(new Integer[]{in.nextInt(), in.nextInt()});
        }
        System.out.println(solution3(list));
    }

    public static int solution2(ArrayList<Integer[]> list){
        //시간을 기준으로 내림차순 정렬
        Collections.sort(list, ((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o2[0] - o1[0];
            }
            return o2[1] - o1[1];
        }));

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        int max = list.get(0)[1];
        int flag = list.get(0)[1];
        for(int i = 0; i < list.size(); i++){
            if(list.get(i)[1] == flag){
                queue.add(list.get(i)[0]);
            } else {
                int temp = flag - list.get(i)[1];
                flag = list.get(i)[1];
                i--;
                for(int j = 0; j < temp; j++){
                    if(!queue.isEmpty()){
                        answer += queue.poll();
                    } else {
                        break;
                    }
                }
            }
        }
        for(int i = 0; i < flag; i++){
            answer += queue.poll();
        }
        return answer;
    }

    public static int solution3(ArrayList<Integer[]> list){
        //시간을 기준으로 내림차순 정렬
        Collections.sort(list, ((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o2[0] - o1[0];
            }
            return o2[1] - o1[1];
        }));

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        int max = list.get(0)[1];

        int j = 0;
        for(int i = max; i >= 1; i--){
            for(; j < list.size(); j++){
                if(i != list.get(j)[1]) break;
                queue.add(list.get(j)[0]);
            }
            if(!queue.isEmpty()) answer += queue.poll();
        }
        return answer;
    }
}
