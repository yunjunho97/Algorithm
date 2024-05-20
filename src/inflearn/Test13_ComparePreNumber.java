package inflearn;

import java.util.Scanner;

public class Test13_ComparePreNumber {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int count = in.nextInt();
        in.nextLine();
        String input = in.nextLine();
        System.out.println(solution(input, count));
    }

    //자신의 바로 앞 수보다 큰 수만 한 줄로 출력
    public static String solution(String input, int count){
        String answer = "";
        input = "0 " + input;
        for(int i = 1; i < count+1; i++){
            int a = Integer.parseInt(input.split(" ")[i]);
            int b = Integer.parseInt(input.split(" ")[i-1]);
            if(a > b){
                answer += (a + " ");
            }
        }
        return answer;
    }
}
