package inflearn;

import java.util.Scanner;
import java.util.Stack;

public class Test40_Stack5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(solution(input));
    }

    public static int solution(String input){
        int answer = 0;

        Stack<Character> stack = new Stack<>();
        int flag = 0;
        for(char c : input.toCharArray()){
            if(c == '('){
                flag = 1;
                stack.push(c);
            } else if(c == ')'){
                stack.pop();
                if(flag == 1){
                    answer += stack.size();
                    flag = 0;
                } else{
                    answer += 1;
                }
            }
        }

        return answer;
    }
}
