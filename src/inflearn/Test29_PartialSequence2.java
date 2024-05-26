package inflearn;

import java.util.Scanner;

public class Test29_PartialSequence2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(solution(n));
        System.out.println(solution2(n));
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

    //수학적 풀이
    //15가 연속된 두 자연수의 합이 되는지?
    //1, 2를 놔두고 15에서 (1+2)를 빼면 12가 남음
    //12를 2로 나누면 6, 6으로 나누어 떨어짐
    //1+6, 2+6으로 각각 분배해주면 된다

    //15 3? 1, 2, 3 -> ...
    public static int solution2(int n){
        int answer = 0;

        int count = 1;
        n -= count;

        while(n > 0){
            count++;
            n -= count;
            if(n % count == 0){
                answer++;
            }
        }

        return answer;
    }
}
