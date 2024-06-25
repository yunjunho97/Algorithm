package programmers;

import java.util.Arrays;

public class Test28 {
    public static void main(String[] args) {
        //1 2 3 4 5 6 7
        //2 2 3 4 5 6 7
        //3 3 3 4 5 6 7
        //4 4 4 4 5 6 7
        //5 5 5 5 5 6 7
        //6 6 6 6 6 6 7
        //7 7 7 7 7 7 7
        System.out.println(Arrays.toString(solution(4,1,2)));
    }

    public static int[] solution(int n, long left, long right){
        long i = left / n;
        long j = (left % n);
        long sum = right - left + 1;
        int[] answer = new int[(int)sum];
        int count = 0;
        while(count < sum){
            if(i >= j){
                answer[count] = (int)i+1;
            } else {
                answer[count] = (int)j+1;
            }
            count++;
            j++;
            if(j == n) {
                j = 0;
                i++;
            }
        }
        return answer;
    }
}
