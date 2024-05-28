package inflearn;

import java.util.Scanner;
import java.util.Stack;

public class Test38_Stack3 {
    public static void main(String[] args) {
//        입력
//        5
//        0 0 0 0 0
//        0 0 1 0 3
//        0 2 5 0 1
//        4 2 4 4 2
//        3 5 1 3 1
//        8
//        1 5 3 5 1 2 1 4

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] board = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = in.nextInt();
            }
        }
        int m = in.nextInt();
        int[] move = new int[m];
        for(int i = 0; i < m; i++){
            move[i] = in.nextInt();
        }

        System.out.println(solution(board, move));
    }

    //2차원 배열의 보드에서 인형뽑기
    public static int solution(int[][] board, int[] move){
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for(int i : move){
            for(int j = 0; j < board.length; j++) {
                if(board[j][i-1] != 0){
                    if(!stack.isEmpty() && stack.peek() == board[j][i-1]){
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(board[j][i-1]);
                    }
                    board[j][i-1] = 0;
                    break;
                }
            }
        }

        return answer;
    }
}
