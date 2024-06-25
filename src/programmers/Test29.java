package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class Test29 {
    static ArrayList<long[]> list = new ArrayList<>();
    static long left = Long.MAX_VALUE;
    static long right = Long.MIN_VALUE;
    static long top = Long.MIN_VALUE;
    static long bottom = Long.MAX_VALUE;
    public static void main(String[] args) {
        int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
        int[][] line2 = {{0,1,-1}, {1,0,-1},{1,0,1}};
        String[] a = solution(line2);
        System.out.println(Arrays.toString(a));
    }

    public static String[] solution(int[][] line){
        for(int i = 0; i < line.length; i++){
            for(int j = i+1; j < line.length; j++){
                calculate2(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);
            }
        }
        long w = right - left + 1;
        long l = top - bottom + 1;
        long shiftW = -1 * left; //+
        long shiftL = top; //-

        String[][] answer = new String[(int)l][(int)w];
        for(String[] row : answer) {
            Arrays.fill(row, ".");
        }

        for(long[] i : list){
            answer[(int)shiftL-(int)i[1]][(int)i[0]+(int)shiftW] = "*";
        }

        String[] result = new String[answer.length];
        for(int i = 0; i < result.length; i++){
            String temp = "";
            for(int j = 0; j < answer[0].length; j++){
                temp += answer[i][j];
            }
            result[i] = temp;
        }
        return result;
    }

    public static void calculate2(int A, int B, int E, int C, int D, int F){
        double x = (double) (((long)B*(long)F) - ((long)E*(long)D)) / (((long)A*(long)D) - ((long)B*(long)C));
        double y = (double) (((long)E*(long)C) - ((long)A*(long)F)) / (((long)A*(long)D) - ((long)B*(long)C));
        if(x % 1 == 0 && y % 1 == 0) {
            list.add(new long[]{(long)x, (long)y});
            if(x < left) left = (long)x;
            if(right < x) right = (long)x;
            if(y < bottom) bottom = (long)y;
            if(top < y) top = (long)y;
        }
    }
}
