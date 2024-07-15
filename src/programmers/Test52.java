package programmers;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;

public class Test52 {
    public static void main(String[] args) {
        String number = "4177252841";
        int k = 4;
        System.out.println(solution(number, k));
    }

    public static String solution(String number, int k){
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        // k가 0이 아닌 경우, 남은 k만큼 스택에서 제거
        while (k > 0) {
            stack.pop();
            k--;
        }

        // 결과 문자열 생성
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return new String(result);
    }
}
