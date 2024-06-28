package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class Test38 {
    //10
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("110010101001")));
    }
    public static int[] solution(String s){
        int count = 0;
        int sum = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while(!s.equals("1")){
            count++;
            int length1 = s.length();
            s = s.replace("0", "");
            int length2 = s.length();
            sum += length1 - length2;
            s = Integer.toBinaryString(length2);
        }
        return new int[]{count, sum};
    }
}
