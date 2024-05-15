package inflearn;

import java.util.Scanner;

public class Test9_NumberExtraction {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(solution(input));
    }

    //문자열에서 숫자만 추출
    public static int solution(String input){
        input = input.replaceAll("[^0-9]", "");
        int answer = Integer.parseInt(input);
        return answer;
    }

    //isDigit() 사용
    public static int solution2(String input){
        String answer = "";
        for(char x : input.toCharArray()){
            if(Character.isDigit(x)){
                answer += x;
            }
        }
        return Integer.parseInt(answer);
    }

}
