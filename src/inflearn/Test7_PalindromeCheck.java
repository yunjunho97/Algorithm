package inflearn;

import java.util.Scanner;

public class Test7_PalindromeCheck {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(solution(input));
        System.out.println(solution2(input));
    }

    //Palindrome(회문)인지 확인하기
    public static String solution(String input){
        String answer = "YES";

        int LP = 0;
        int RP = input.length()-1;
        while(LP < RP){
            if(Character.toUpperCase(input.charAt(LP)) == Character.toUpperCase(input.charAt(RP))){
                LP++;
                RP--;
            } else{
                answer = "NO";
                return answer;
            }
        }

        return answer;
    }

    //StringBuilder, equalsIgnoreCase 사용
    public static String solution2(String input){
        String answer = "YES";

        if(input.equalsIgnoreCase(new StringBuilder(input).reverse().toString())){
            answer = "YES";
        } else {
            answer = "NO";
        }

        return answer;
    }
}
