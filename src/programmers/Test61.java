package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Test61 {
    public static void main(String[] args) {
        int[] prices = {1,2,3,2,3};
        System.out.println(Arrays.toString(solution(prices)));
    }

    public static int[] solution(int[] prices){
        Queue<Integer> queue = new LinkedList<>();
        int[] answer = new int[prices.length];
        queue.add(0);

        for(int i = 1; i < prices.length; i++){
            Queue<Integer> temp = new LinkedList<>();
            while(!queue.isEmpty()){
                int point = queue.poll();
                answer[point]++;
                if(prices[point] <= prices[i]) {
                    temp.add(point);
                }
            }
            queue = temp;
            queue.add(i);
        }
        return answer;
    }
}
