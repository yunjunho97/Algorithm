package inflearn;

import java.util.Scanner;

public class Test3_LongestWordSearch {
    public static void main(String[] args) {
        Test3_LongestWordSearch longestWordSearch = new Test3_LongestWordSearch();
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(longestWordSearch.solution(str));
    }

    public static String solution(String str){
        String answer = "";

        for(String word : str.split(" ")){
            if(word.length() > answer.length()){
                answer = word;
            }
        }

        return answer;
    }
}
