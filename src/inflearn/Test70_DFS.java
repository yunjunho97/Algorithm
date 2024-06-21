package inflearn;

import java.util.Scanner;

public class Test70_DFS {
    static int count;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        solution(0, in.nextInt());
        System.out.println(count);
    }

    public static void solution(int sum, int n){
        if(sum == n) count++;
        if(sum > n) return;
        for(int i = 1; i <= 2; i++){
            solution(sum+i, n);
        }
    }
}
