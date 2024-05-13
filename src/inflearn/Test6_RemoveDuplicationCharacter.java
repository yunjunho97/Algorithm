package inflearn;

import java.util.Scanner;

public class Test6_RemoveDuplicationCharacter {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String inputString = in.nextLine();
        System.out.println(solution(inputString));
    }
    public static String solution(String inputString){
        String answer = "";

        //알파벳 26자리를 위한 체크리스트 생성
        int[] checkList = new int[26];

        for(int i = 0; i < inputString.length(); i++){

            //체크리스트가 0이면 1로 바꿔주고 해당 알파벳을 answer에 추가
            if(checkList[inputString.charAt(i)-97] == 0){
                checkList[inputString.charAt(i)-97] = 1;
                answer += inputString.charAt(i);
            }
        }

        return answer;
    }
}
