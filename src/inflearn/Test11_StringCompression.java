package inflearn;

import java.util.Scanner;

public class Test11_StringCompression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(solution(str));
    }

    //문자열 압축
    //KKHSSSSS -> K2HS5
    public static String solution(String inputString){
        String answer = "";

        for(int i = 0; i < inputString.length(); i++){

            //현재 인덱스에 해당하는 char
            char temp = inputString.charAt(i);
            answer += temp;
            int count = 1;
            //temp와 같을경우 계속 반복
            while((i+count < inputString.length()) && (temp == inputString.charAt(i+count))){
                count++;
            }
            if(count > 1){
                answer += count;
            }

            //같은 부분의 최종지점까지 i를 점프
            i += (count-1);

        }

        return answer;
    }

    //마지막에 공백을 추가하고 length-1까지 반복
    public static String solution2(String inputString){
        String answer = "";

        inputString += " "; //outofrange에러를 방지하기 위해 문자열의 끝에 공백 추가

        int count = 1;
        for(int i = 0; i < inputString.length()-1; i++){
            if(inputString.charAt(i) == inputString.charAt(i+1)){
                count++;
            } else {
                answer += inputString.charAt(i);
                if(count > 1){
                    answer += count;
                }
                count = 1;
            }
        }

        return answer;
    }
}
