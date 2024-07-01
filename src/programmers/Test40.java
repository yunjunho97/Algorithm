package programmers;

import java.util.Arrays;

public class Test40 {
    static int[][] board;
    static int num = 1;
    static int w = 0;
    static int l = -1;
    static int count;
    public static void main(String[] args) {
        solution(5);
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[] solution(int n) {
        board = new int[n][n];
        count = n;
        int flag = 1;
        while(count > 0){
            if(flag == 1) {
                section1();
                flag = 2;
            } else if(flag == 2) {
                section2();
                flag = 3;
            } else if(flag == 3){
                section3();
                flag = 1;
            }
        }
        int pointer = 0;
        int[] answer = new int[(n * (n+1)) / 2];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i+1; j++){
                answer[pointer++] = board[i][j];
            }
        }

        return answer;
    }

    public static void section1(){
        for(int i = 0; i < count; i++){
            l++;
            board[l][w] = num++;
        }
        count--;
    }
    public static void section2(){
        for(int i = 0; i < count; i++){
            w++;
            board[l][w] = num++;
        }
        count--;
    }
    public static void section3(){
        for(int i = 0; i < count; i++){
            l--;
            w--;
            board[l][w] = num++;
        }
        count--;
    }
}
