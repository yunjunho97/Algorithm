package inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test65_BFS {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int w = in.nextInt();
        int l = in.nextInt();
        int[][] board = new int[l][w];
        for(int i = 0; i < l; i++){
            for(int j = 0; j < w; j++){
                board[i][j] = in.nextInt();
            }
        }
        System.out.println(solution(board));
    }

    public static int solution(int[][] board){
        int[] dl = {0, 0, 1, -1};
        int[] dw = {1, -1, 0, 0};
        int sum = 0;
        Queue<Node65> queue = new LinkedList<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 1){
                    queue.offer(new Node65(i, j, 0));
                } else if(board[i][j] == 0){
                    sum++;
                }
            }
        }
        if(sum == 0) return 0;
        while(!queue.isEmpty()){
            Node65 temp = queue.poll();
            if(sum == 0){
                return temp.count+1;
            }
            for(int i = 0; i < 4; i++){
                int l = temp.l + dl[i];
                int w = temp.w + dw[i];
                if(l < 0 || l >= board.length || w < 0 || w >= board[0].length || board[l][w] != 0){
                    continue;
                }
                queue.offer(new Node65(l, w, temp.count+1));
                board[l][w] = 2;
                sum--;
            }
        }
        return -1;
    }
}

class Node65{
    int l;
    int w;
    int count;
    public Node65(int l, int w, int count){
        this.l = l;
        this.w = w;
        this.count = count;
    }
}
