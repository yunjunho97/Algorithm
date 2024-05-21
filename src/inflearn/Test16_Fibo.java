package inflearn;

import java.util.Scanner;

public class Test16_Fibo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        long[] arr = solution(n);
//        for (int i = 0; i < n; i++) {
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println(arr[n-1]);
        solution2(n);
    }

    public static long[] solution(int input){
        long[] answer = new long[input];

        answer[0] = 1;
        answer[1] = 1;
        for(int i = 2; i < input; i++){
            answer[i] = answer[i-1] + answer[i-2];
        }

        return answer;
    }

    //배열 없이
    public static void solution2(int input){
        int a = 1;
        int b = 1;
        int c = 0;
        for(int i = 2; i < input; i++){
            c = a + b;
            a = b;
            b = c;
        }
        System.out.println(c);
    }
}
