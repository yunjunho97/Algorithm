package inflearn;

import java.util.*;

public class Test62_DisjointSetUnionFind {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int students = in.nextInt();
        int n = in.nextInt();
        int[][] board = new int[students+1][students+1];
        for(int i = 0; i < n; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            board[a][b] = 1;
            board[b][a] = 1;
        }
        int target1 = in.nextInt();
        int target2 = in.nextInt();

        System.out.println(solution(board, target1, target2));
    }

    public static String solution(int[][] board, int target1, int target2){
        Stack<Integer> stack = new Stack<>();
        stack.push(target1);
        while(!stack.isEmpty()){
            int temp = stack.pop();
            for(int i = 1; i < board.length; i++){
                if(board[temp][i] == 1){
                    board[temp][i] = 2;
                    board[i][temp] = 2;
                    if(i == target2) {
                        return "YES";
                    } else {
                        stack.push(i);
                    }
                }
            }
        }
        return "NO";
    }

}
