package programmers;

import java.util.PriorityQueue;

public class Test58 {
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int k = 7;
        System.out.println(solution(scoville, k));
    }

    public static int solution(int[] scoville, int k){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i : scoville) queue.add(i);

        int answer = 0;
        while(queue.size() >= 2) {
            if(queue.peek() < k) queue.add(queue.poll() + (queue.poll() * 2));
            else break;
            answer++;
        }
        if(queue.peek() < k) answer = -1;
        return answer;
    }
}
