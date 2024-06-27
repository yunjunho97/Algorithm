package programmers;

import java.util.Arrays;

public class Test34 {
    //30분
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int rows = 6;
        int columns = 6;
        int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
        System.out.println(Arrays.toString(solution(rows, columns, queries)));
    }

    public static int[] solution(int rows, int columns, int[][] queries){
        int[][] board = new int[rows][columns];
        int count = 1;
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                board[i][j] = count++;
            }
        }
        int[] answer = new int[queries.length];
        for(int i = 0; i < answer.length; i++){
            board = rotation(board, queries[i]);
            answer[i] = min;
            min = Integer.MAX_VALUE;
        }
        return answer;
    }

    public static int[][] rotation(int[][] board, int[] query){
        int startL = query[0]-1;
        int startW = query[1]-1;
        int endL = query[2]-1;
        int endW = query[3]-1;

        int temp1 = board[startL][startW];
        int temp2;
        for(int i = startW; i < endW; i++){
            if(temp1 < min) min = temp1;
            temp2 = board[startL][i+1];
            board[startL][i+1] = temp1;
            temp1 = temp2;
        }
        for(int i = startL; i < endL; i++){
            if(temp1 < min) min = temp1;
            temp2 = board[i+1][endW];
            board[i+1][endW] = temp1;
            temp1 = temp2;
        }
        for(int i = endW; i > startW; i--){
            if(temp1 < min) min = temp1;
            temp2 = board[endL][i-1];
            board[endL][i-1] = temp1;
            temp1 = temp2;
        }
        for(int i = endL; i > startL; i--){
            if(temp1 < min) min = temp1;
            temp2 = board[i-1][startW];
            board[i-1][startW] = temp1;
            temp1 = temp2;
        }
        return board;
    }
}
