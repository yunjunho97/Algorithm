package inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test41_Queue1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        System.out.println(solution(n, k));
    }

    public static int solution(int n, int k){
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i < n+1; i++){
            queue.add(i);
        }

        int count = 0;
        while(queue.size() > 1){
            count++;
            int pick = queue.poll();
            if(count == k){
                count = 0;
                continue;
            }
            queue.add(pick);
        }

        answer = queue.poll();

        return answer;
    }
}
