package inflearn;

import java.util.Scanner;
import java.util.Stack;

public class Test36_Stack1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine(); //(()(()))(()
        System.out.println(solution(input));
    }

    //올바른 괄호인지 확인
    public static String solution(String input){
        String answer = "YES";

        Stack<Character> stack = new Stack<>();
        for(char c : input.toCharArray()){
            if(c == '('){
                stack.push(c);
            } else {
                if(stack.isEmpty()){
                    return "NO";
                } else{
                    stack.pop();
                }
            }
        }
        if(!stack.isEmpty()){
            return "NO";
        }

        return answer;
    }
}
