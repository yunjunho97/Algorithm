package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class Test4 {
    public static void main(String[] args) {
        int[][] list = {{7,7},{2,7},{7,3}};
        int[] list2 = solution(10, 10, 3, 7, list);
        System.out.println(Arrays.toString(list2));
    }

    public static int[] solution(int m, int n, int startX, int startY, int[][] balls){
        //m = 가로, n = 세로
        //x = 가로, y = 세로
        int[] result = new int[balls.length];
        for(int i = 0; i < balls.length; i++){
            //balls 선대칭
            int[][] list = new int[4][2];
            //아래
            list[0] = new int[]{balls[i][0], -balls[i][1]};
            //위
            list[1] = new int[]{balls[i][0], n + n - balls[i][1]};
            //오른쪽
            list[2] = new int[]{m + m - balls[i][0], balls[i][1]};
            //왼쪽
            list[3] = new int[]{-balls[i][0], balls[i][1]};

            TreeSet<Integer> set = new TreeSet<>();
            for(int j = 0; j < 4; j++){
                if(startX == balls[i][0] && startY > balls[i][1] && j == 0){
                    continue;
                }
                if(startX == balls[i][0] && startY < balls[i][1] && j == 1){
                    continue;
                }
                if(startX < balls[i][0] && startY == balls[i][1] && j == 2){
                    continue;
                }
                if(startX > balls[i][0] && startY == balls[i][1] && j == 3){
                    continue;
                }
                set.add((int)Math.pow(startX - list[j][0], 2) + (int)Math.pow(startY - list[j][1], 2));
            }
            result[i] = set.first();
        }
        return result;
    }
}
