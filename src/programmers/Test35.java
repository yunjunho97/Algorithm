package programmers;

import java.util.Stack;

public class Test35 {
    //20분
    public static void main(String[] args) {
        System.out.println(solution("{"));
    }

    public static int solution(String s){
        int answer = 0;
        char[] arr = s.toCharArray();
        int pointer = 0;
        int count = arr.length;
        for(int i = 0; i < arr.length; i++){
            if(calculate(pointer, count, arr)) answer++;
            pointer++;
        }
        return answer;
    }

    public static boolean calculate(int pointer, int count, char[] arr){
        Stack<Character> stack = new Stack<>();
        while(count > 0){
            char c = arr[pointer];
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if(c == ')') {
                if(stack.isEmpty() || stack.pop() != '(') return false;
            } else if(c == ']') {
                if(stack.isEmpty() || stack.pop() != '[') return false;
            } else if(c == '}') {
                if(stack.isEmpty() || stack.pop() != '{') return false;
            }
            count--;
            pointer++;
            pointer %= arr.length;
        }
        return stack.isEmpty();
    }
}
