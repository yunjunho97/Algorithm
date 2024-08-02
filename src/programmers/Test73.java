package programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test73 {
    public static void main(String[] args) {
        int n = 2;
        String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
        System.out.println(Arrays.toString(solution(n, words)));
    }

    public static int[] solution(int n, String[] words){
        int[] answer = {0, 1};
        Set<String> set = new HashSet<>();
        int i = 1;
        String before = "";
        for(String word : words){
            if(i > n) {
                i = 1;
                answer[1] += 1;
            }
            if(!set.add(word) || !word.startsWith(before)){
                answer[0] = i;
                return answer;
            }
            before = String.valueOf(word.charAt(word.length()-1));
            i++;
        }
        return new int[]{0, 0};
    }
}
