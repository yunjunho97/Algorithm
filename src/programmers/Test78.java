package programmers;

public class Test78 {
    static int result = 0;
    public static void main(String[] args) {
        int n = 4;
        System.out.println(solution(n));
    }

    public static int solution(int n){
        int[][] board = new int[n][n];
        int[] checkW = new int[n];

        recursive(0, board, checkW);
        return result;
    }

    public static void recursive(int l, int[][] board, int[] checkW){
        if(l == board.length) {
            result++;
            return;
        }

        for(int w = 0; w < board.length; w++){
            if(checkW[w] == 1 || !checkV(l, w, board)) continue;
            checkW[w] = 1;
            board[l][w] = 1;
            recursive(l+1, board, checkW);
            checkW[w] = 0;
            board[l][w] = 0;
        }
    }

    public static boolean checkV(int l, int w, int[][] board){
        int posL = l;
        int posW = w;

        posL--;
        posW++;
        while(0 <= posL && posL < board.length && 0 <= posW && posW < board.length){
            if(board[posL][posW] == 1) return false;
            posL--;
            posW++;
        }

        posL = l;
        posW = w;
        posL--;
        posW--;
        while(0 <= posL && posL < board.length && 0 <= posW && posW < board.length){
            if(board[posL][posW] == 1) return false;
            posL--;
            posW--;
        }

        return true;
    }
}
