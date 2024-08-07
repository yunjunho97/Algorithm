package programmers;

import java.util.Arrays;
import java.util.Collections;

public class Test83 {
    public static void main(String[] args) {

    }

    public static int solution(int[] A, int[] B){
        Arrays.sort(A);
        Arrays.sort(B);
        int sum = 0;
        for(int i = 0; i < A.length; i++){
            sum += A[i] * B[B.length-1-i];
        }
        return sum;
    }
}
