package programmers_level3;

import java.util.Arrays;

public class Test11 {
    public static void main(String[] args) {
        long[] numbers = {63, 111, 95, 15};
        System.out.println(Arrays.toString(solution(numbers)));
    }

    public static int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for(int i = 0; i < numbers.length; i++) {
            String tree = fullTree(Long.toString(numbers[i], 2));
            if(!isEnableTree(tree)) {
                answer[i] = 0;
            } else {
                answer[i] = 1;
            }
        }

        return answer;
    }

    public static String fullTree(String tree) {
        long init = 1;
        long size = tree.length();
        while(true) {
            size -= init;
            if(size > 0) {
                init *= 2;
            } else if(size < 0) {
                StringBuilder sb = new StringBuilder(tree);
                for(long i = 0; i < size*-1; i++) {
                    sb.insert(0, "0");
                }
                tree = sb.toString();
                break;
            } else {
                break;
            }
        }

        return tree;
    }

    public static boolean isEnableTree(String tree) {
        if(tree.length() == 1) return true;

        int point = tree.length() / 2;

        if(tree.charAt(point) == '0') {
            if(tree.contains("1")) return false;
            else return true;
        }

        if(!isEnableTree(tree.substring(0, point))) return false;
        if(!isEnableTree(tree.substring(point+1))) return false;

        return true;
    }
}
