package inflearn;

import java.util.Scanner;

public class Test27_SlidingWindow {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int entire = in.nextInt();
        int target = in.nextInt();
        int[] list = new int[entire];
        for(int i = 0; i < entire; i++){
            list[i] = in.nextInt();
        }
        System.out.println(solution(entire, target, list));
    }

    //연속된 target일 동안의 최대 합, sliding window
    public static int solution(int entire, int target, int[] list){
        int answer = 0;

        int sum = 0;
        //첫 target일의 합
        for(int i = 0; i < target; i++){
            sum += list[i];
        }
        answer = sum;
        for(int i = 0; i < entire-target; i++){
            sum = sum - list[i] + list[i+target];
            if(sum > answer){
                answer = sum;
            }
        }

        return answer;
    }
}
