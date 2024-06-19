package inflearn;

import java.util.Scanner;

public class Test63_DFS {
    static int answer = 0;
    static int[][] board = new int[7][7];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 7; j++){
                board[i][j] = in.nextInt();
            }
        }
        solution(new Node63(0, 0));
        System.out.println(answer);
    }

    public static void solution(Node63 node){
        board[node.l][node.w] = 2;
        if(node.l == 6 && node.w == 6) {
            board[node.l][node.w] = 0;
            answer++;
            return;
        }

        int[] dw = {1, -1, 0, 0};
        int[] dl = {0, 0, 1, -1};
        for(int i = 0; i < 4; i++){
            int l = node.l + dl[i];
            int w = node.w + dw[i];
            if(l < 0 || l > 6 || w < 0 || w > 6){
                continue;
            }
            if(board[l][w] == 0) {
                solution(new Node63(l, w));
            }
        }
        board[node.l][node.w] = 0;
    }
}
class Node63{
    int l;
    int w;
    public Node63(int l, int w){
        this.l = l;
        this.w = w;
    }
}
