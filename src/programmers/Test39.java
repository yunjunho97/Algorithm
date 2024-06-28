package programmers;

import java.util.Arrays;

public class Test39 {
    //50
    static int[] answer = new int[3];
    public static void main(String[] args) {
        int[][] arr = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
        int[][] arr2 = {{1,1,1,1,1,1,1,1},
                {0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},
                {0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}};
        System.out.println(Arrays.toString(solution(arr2)));
    }

    public static int[] solution(int[][] arr){
        recursive(arr.length*arr.length, 0, 0, arr.length-1, arr.length-1, arr);
        int[] result = new int[2];
        result[0] = answer[0];
        result[1] = answer[1];
        return result;
    }

    //0 0 7 7
    //0 0 3 3 / 0 4 3 7
    //4 0 7 3 / 4 4 7 7
    public static int recursive(int size, int sl, int sw, int el, int ew, int[][] arr){
        if(size == 1) {
            int temp = arr[sl][sw];
            answer[temp]++;
            return temp;
        }
        int cl = (sl + el) / 2;
        int cw = (sw + ew) / 2;
        int a = recursive(size/4, sl, sw, cl, cw, arr);
        int b = recursive(size/4, sl, cw+1, cl, ew, arr);
        int c = recursive(size/4, cl+1, sw, el, cw, arr);
        int d = recursive(size/4, cl+1, cw+1, el, ew, arr);
        if(a == b && b == c && c == d) {
            answer[a] -= 3;
            return a;
        }
        return 2;
    }
}
