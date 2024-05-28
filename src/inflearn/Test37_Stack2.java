package inflearn;

import java.util.Scanner;
import java.util.Stack;

public class Test37_Stack2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine(); //(A(BC)D)EF(G(H)(IJ)K)LM(N)
        System.out.println(solution(input));
    }

    //괄호안에 있는 문자 제거
    public static String solution(String input){
        String answer = "";

        Stack<Character> stack = new Stack<>();

        for(char c : input.toCharArray()){
            if(c == '('){
                stack.push(c);
            } else if(c == ')'){
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                if(stack.isEmpty()){
                    answer += c;
                }
            }
        }

        return answer;
    }
}
