package inflearn;

import java.util.Scanner;

public class Test12_BaseConversion {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        String inputString = in.next();
        System.out.println(solution(inputString, count));
        System.out.println(solution2(inputString, count));
    }

    //2진수 10진수 변환
    //input: # * 조합의 String
    //# == 1, * == 0
    public static String solution(String inputString, int count){
        String answer = "";

        String temp = "";
        for(int i = 0; i < inputString.length(); i++){
            if(inputString.charAt(i) == '#'){
                temp += 1;
            } else {
                temp += 0;
            }
            if((i+1) % 7 == 0){
                int num = Integer.parseInt(temp, 2);
                char c = (char)num;
                answer += c;
                temp = "";
            }
        }

        return answer;
    }

    //
    public static String solution2(String inputString, int count){
        String answer = "";

        for(int i = 0; i < count; i++){
            String temp = inputString.substring(0, 7).replaceAll("#", "1")
                    .replaceAll("\\*", "0");
            int num = Integer.parseInt(temp, 2);
            char c = (char)num;
            answer += c;
            inputString = inputString.substring(7);
        }

        return answer;
    }
}
