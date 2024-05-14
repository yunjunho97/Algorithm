package inflearn;

import java.util.Scanner;

public class Test9_NumberExtraction {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(solution(input));
    }

    public static int solution(String input){
        input = input.replaceAll("[^0-9]", "");
        int answer = Integer.parseInt(input);
        return answer;
    }
}
