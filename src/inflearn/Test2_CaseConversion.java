package inflearn;

import java.util.Scanner;

public class Test2_CaseConversion {

    public static void main(String[] args){
        Test2_CaseConversion caseConversion = new Test2_CaseConversion();
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(caseConversion.solution(input));

    }

    public static String solution(String str){
        String answer = "";
        for(char c : str.toCharArray()){
            if(Character.isUpperCase(c)){
                answer += Character.toLowerCase(c);
            } else {
                answer += Character.toUpperCase(c);
            }
        }
        return answer;
    }
}