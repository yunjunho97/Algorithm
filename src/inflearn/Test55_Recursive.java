package inflearn;

import java.util.Scanner;

public class Test55_Recursive {
    static int max;
    static int total = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        max = in.nextInt();
        int n = in.nextInt();
        int[] list = new int[n];
        for(int i = 0; i < n; i++){
            list[i] = in.nextInt();
        }

        solution2(0, 0, list);
        System.out.println(total);
    }

    public static void solution2(int l, int sum, int[] list){
        if(sum > max) return;
        if(sum > total) total = sum;
        if(l == list.length) return;

        solution2(l+1, sum+list[l], list);
        solution2(l+1, sum, list);
    }
}
