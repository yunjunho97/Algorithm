package inflearn;

import java.util.Scanner;

public class Test56_Recursive {
    static int timeLimit;
    static int highScore = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        timeLimit = in.nextInt();
        int[][] list = new int[n][n];
        for(int i = 0; i < n; i++){
            list[i][0] = in.nextInt();
            list[i][1] = in.nextInt();
        }

        solution(0, 0, 0, list);
        System.out.println(highScore);
    }

    public static void solution(int l, int score, int time, int[][] list){
        if(time > timeLimit) return;
        if(score > highScore) highScore = score;
        if(l == list.length) return;

        solution(l+1, score+list[l][0], time+list[l][1], list);
        solution(l+1, score, time, list);
    }
}
