package inflearn;

import java.util.Scanner;

public class Test2_CaseConversion {

    public static void main(String[] args){
        Test2_CaseConversion caseConversion = new Test2_CaseConversion();
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(caseConversion.solution2(input));

    }

    public static String solution(String str){
        String answer = "";
        for(char c : str.toCharArray()){
            if(Character.isUpperCase(c)){
                answer += Character.toLowerCase(c);
                //대문자라면 소문자로 변환
            } else {
                answer += Character.toUpperCase(c);
                //소문자라면 대문자로 변환
            }
        }
        return answer;
    }

    //아스키코드를 활용한 방법
    //A~Z: 65~90
    //a~z: 97~122
    //대문자와 소문자의 차이는 32
    public static String solution2(String str){
        String answer = "";
        for(char c : str.toCharArray()){
            if(c >= 65 && c <= 97){
                answer += (char)(c+32);
                //대문자라면 소문자로 변환
            } else {
                answer += (char)(c-32);
                //소문자라면 대문자로 변환
            }
        }
        return answer;
    }
}