package inflearn;

import java.util.Arrays;

public class Test58_Recursive {
    public static void main(String[] args) {
        int m = 5;
        int[] arr = new int[m];
        solution(3, m, 0, arr);
    }
    //중복 순열
    public static void solution(int n, int m, int start, int[] arr){
        if(start == arr.length){
            System.out.println(Arrays.toString(arr));
            return;
        }

        for(int i = 1; i < n+1; i++){
            arr[start] = i;
            solution(n, m, start+1, arr);
        }
    }
}
