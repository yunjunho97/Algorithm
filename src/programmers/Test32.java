package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Test32 {
    //50분
    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        System.out.println(Arrays.toString(solution(places)));
    }

    public static int[] solution(String[][] places){
        int[] answer = new int[5];

        int[] dw = {1, -1, 0, 0};
        int[] dl = {0, 0, 1, -1};

        for(int k = 0; k < 5; k++){
            Queue<int[]> queue = new LinkedList<>();
            int[][] check = new int[5][5];
            char[][] place = new char[5][5];
            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 5; j++){
                    if(places[k][i].charAt(j) == 'P') queue.add(new int[]{i, j});
                    place[i][j] = places[k][i].charAt(j);
                }
            }
            int result = checkPlace(queue, dw, dl, place, check);
            answer[k] = result;
        }

        return answer;
    }

    public static boolean recursive(int count, int l, int w, int[] dw, int[] dl, char[][] place, int[][] check){
        if(count == 3) return true;
        if(count != 0) {
            if(check[l][w] == 1 || place[l][w] == 'X') return true;
            if(place[l][w] == 'P') return false;
        }
        check[l][w] = 1;
        for(int i = 0; i < 4; i++){
            int nextW = w + dw[i];
            int nextL = l + dl[i];
            if(nextL < 0 || nextL > 4 || nextW < 0 || nextW > 4) continue;
            if(!recursive(count+1, nextL, nextW, dw, dl, place, check)) return false;
        }
        return true;
    }

    public static int checkPlace(Queue<int[]> queue, int[] dw, int[] dl, char[][] place, int[][] check){
        while(!queue.isEmpty()){
            //0i = l, 1j = w
            int[] position = queue.poll();
            if(!recursive(0, position[0], position[1], dw, dl, place, check)) return 0;
        }
        return 1;
    }
}
