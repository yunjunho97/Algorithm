package inflearn;

import java.util.Scanner;

public class Test54 {
    static boolean flag = false;
    static int total;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }
        solution(arr);
        if(flag) System.out.println("YES");
        else System.out.println("NO");
    }

    public static void solution(int[] arr){
        total = 0;
        for(int x : arr){
            total += x;
        }
        solution2(0, 0, arr);
    }
    public static void solution2(int l, int sum, int[] arr){
        if(total-sum == sum) flag = true;

        if(flag) return;
        if(l == arr.length) return;

        solution2(l+1, sum + arr[l], arr);
        solution2(l+1, sum, arr);
    }
}
