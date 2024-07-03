package programmers;

import java.util.Stack;

public class Test44 {
    public static void main(String[] args) {
        System.out.println(solution("()))((()"));
    }
    //90
    public static String solution(String p){
        String u = "";
        int balance = 0;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < p.length(); i++){
            if(p.charAt(i) == '(') {
                balance--;
                stack.push('(');
            } else {
                balance++;
                if(!stack.isEmpty()) stack.pop();
            }
            u += p.charAt(i);
            if(balance == 0) {
                String temp = new StringBuilder(p).substring(i+1, p.length());
                if(stack.isEmpty()) {
                    return u + solution(temp);
                } else {
                    char[] arr = u.toCharArray();
                    for(int j = 1; j < arr.length-1; j++){
                        if(arr[j] == '(') arr[j] = ')';
                        else arr[j] = '(';
                    }
                    u = new String(arr, 1, arr.length-2);
                    return "(" + solution(temp) + ")" + u;
                }
            }
        }
        return u;
    }
}
