package programmers;

import java.util.Stack;

public class Test76 {
    public static void main(String[] args) {
        System.out.println(solution("baabaa"));
    }

    public static int solution(String s){
        Stack<Integer> stack = new Stack<>();
        char[] arr = s.toCharArray();
        stack.add(0);
        int result = s.length();
        for(int i = 1; i < arr.length; i++){
            if(!stack.isEmpty() && arr[stack.peek()] == arr[i]) {
                stack.pop();
                result -= 2;
            } else {
                stack.add(i);
            }
        }
        if(result == 0) return 1;
        else return 0;
    }
}
