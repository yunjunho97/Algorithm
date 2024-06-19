package inflearn;

import java.util.*;

public class Test64_BFS {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] board = new int[7][7];
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 7; j++){
                board[i][j] = in.nextInt();
            }
        }
        System.out.println(solution(board));
    }

    public static int solution(int[][] board){
        HashMap<Node64, Integer> map = new HashMap<>();
        Queue<Node64> queue = new LinkedList<>();
        int[] dl = {0, 0, 1, -1};
        int[] dw = {1, -1, 0, 0};
        Node64 node = new Node64(0, 0);
        map.put(node, 0);
        queue.add(node);

        while(!queue.isEmpty()){
            Node64 nodeX = queue.poll();
            for(int i = 0; i < 4; i++){
                int l = nodeX.l + dl[i];
                int w = nodeX.w + dw[i];
                if(l < 0 || l > 6 || w < 0 || w > 6 || board[l][w] != 0){
                    continue;
                }
                if(l == 6 && w == 6){
                    return map.get(nodeX) + 1;
                }
                Node64 temp = new Node64(l, w);
                if(board[l][w] == 0){
                    board[l][w] = 2;
                    map.put(temp, map.get(nodeX)+1);
                    queue.add(temp);
                }
            }
        }
        return -1;
    }
}

class Node64{
    int l;
    int w;
    public Node64(int l, int w){
        this.l = l;
        this.w = w;
    }
}
