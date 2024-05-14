package inflearn;

import java.util.Scanner;

public class Test8_PalindromCheckOnlyAlphabet {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(solution(input));
        System.out.println(solution2(input));
    }

    //Palindrome(회문)인지 확인하기
    //알파벳 이외의 문자들은 무시
    public static String solution(String input){
        String answer = "YES";
        int LP = 0;
        int RP = input.length()-1;
        while(LP < RP){
            if(Character.isAlphabetic(input.charAt(LP))){
                if(Character.isAlphabetic(input.charAt(RP))){
                    if(Character.toUpperCase(input.charAt(LP))
                            == Character.toUpperCase(input.charAt(RP))){
                        LP++;
                        RP--;
                    } else{
                        answer = "NO";
                        return answer;
                    }
                } else{
                    RP--;
                }
            } else{
                LP++;
            }
        }
        return answer;
    }

    //정규표현식, replaceAll 사용
    public static String solution2(String input){
        String answer = "YES";

        input = input.toUpperCase().replaceAll("[^A-Z]", "");
        //[^A-Z]: A~Z를 제외한 모든것

        System.out.println(input);
        if(input.equals(new StringBuilder(input).reverse().toString())){
            answer = "YES";
        } else {
            answer = "NO";
        }
        return answer;
    }
}
