package inflearn;

import java.util.Scanner;

public class Test22_PeakFindOnMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n+2][n+2];
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(n, board));
    }

    //위, 아래, 오른쪽, 왼쪽 보다 큰 경우 봉우리가 된다
    public static int solution(int n, int[][] board){
        int answer = 0;
        int[][] check = new int[n+2][n+2];
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < n+1; j++){
                if(check[i][j] == 1){
                    continue;
                }
                int point = board[i][j];
                int top = board[i-1][j];
                int bottom = board[i+1][j];
                int left = board[i][j-1];
                int right = board[i][j+1];
                if(point > top && point > bottom && point > left && point > right){
                    answer++;
                    check[i-1][j] = 1;
                    check[i+1][j] = 1;
                    check[i][j-1] = 1;
                    check[i][j+1] = 1;
                }
            }
        }
        return answer;
    }
}
