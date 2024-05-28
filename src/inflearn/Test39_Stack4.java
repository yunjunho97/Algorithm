package inflearn;

import java.util.Scanner;
import java.util.Stack;

public class Test39_Stack4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String input = in.nextLine(); //352+*9-
        System.out.println(solution(input));
    }

    //후위식 계산
    public static int solution(String input){
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for(char c : input.toCharArray()){
            if(Character.isDigit(c)){
                stack.push(Integer.parseInt(String.valueOf(c)));
            } else {
                int b = stack.pop();
                int a = stack.pop();
                switch (c){
                    case '+':
                        stack.push(a + b);
                        break;
                    case '-':
                        stack.push(a - b);
                        break;
                    case '*':
                        stack.push(a * b);
                        break;
                    case '/':
                        stack.push(a / b);
                        break;
                }
            }
        }

        answer = stack.pop();

        return answer;
    }
}
