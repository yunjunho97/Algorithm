package inflearn;

import java.util.Scanner;

public class Test29_PartialSequence2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(solution(n));
    }

    //합이 n이 되는 연속된 자연수
    public static int solution(int n){
        int answer = 0;

        int forward = 0;
        int backward = 0;
        int sum = 0;
        while(backward <= n/2){
            if(sum < n){
                forward++;
                sum += forward;
            } else if(sum > n) {
                sum -= backward;
                backward++;
            } else {
                answer++;
                forward++;
                sum += forward;
            }
        }

        return answer;
    }
}
