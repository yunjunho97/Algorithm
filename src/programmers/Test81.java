package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class Test81 {
    static ArrayList<int[]> result = new ArrayList<>();
    public static void main(String[] args) {
        int[][] answer = solution(3);
        for(int[] a : answer){
            System.out.println(Arrays.toString(a));
        }
    }

    public static int[][] solution(int n){
        recursive(n, 1, 2, 3);
        int[][] answer = new int[result.size()][2];
        for(int i = 0; i < answer.length; i++){
            answer[i] = result.get(i);
        }
        return answer;
    }

    public static void recursive(int n, int start, int middle, int end){
        if(n == 1) {
            result.add(new int[]{start, end});
            return;
        }

        recursive(n-1, start, end, middle);
        recursive(1, start, middle, end);
        recursive(n-1, middle, start, end);
    }
}
