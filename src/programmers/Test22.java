package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Test22 {
    public static void main(String[] args) {
        int[] in1 = {1,1,1,1};
        int[] in2 = {1,1,7,1};
        System.out.println(solution(in1, in2));
    }

    public static int solution(int[] in1, int[] in2){
        Queue<Long> queue1 = new LinkedList<>();
        Queue<Long> queue2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;
        for(int i = 0; i < in1.length; i++){
            sum1 += in1[i];
            queue1.add((long)in1[i]);
            sum2 += in2[i];
            queue2.add((long)in2[i]);
        }
        int count = 0;
        while(!queue1.isEmpty() && !queue2.isEmpty() && count < in1.length*3){
            if(sum1 > sum2) {
                long temp = queue1.poll();
                queue2.add(temp);
                sum1 -= temp;
                sum2 += temp;
                count++;
            } else if(sum1 < sum2) {
                long temp = queue2.poll();
                queue1.add(temp);
                sum1 += temp;
                sum2 -= temp;
                count++;
            } else {
                return count;
            }
        }
        return -1;
    }
}
