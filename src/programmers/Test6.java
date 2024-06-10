package programmers;

import java.util.Arrays;
import java.util.Stack;

public class Test6 {
    public static void main(String[] args) {
        int[] a = {2,3,3,5};
        int[] b = {9, 1, 5, 3, 6, 2};
        System.out.println(Arrays.toString(solution(b)));
    }

    public static int[] solution(int[] numbers){
        //9, 1, 5, 3, 2, 6, 2
        //v  5  v  v  6
        int[] result = new int[numbers.length];
        result[numbers.length-1] = -1;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < result.length-1; i++){
            if(numbers[i] >= numbers[i+1]){
                result[i] = -1;
                stack.push(i);
            } else {
                result[i] = numbers[i+1];
                while(!stack.isEmpty()){
                    if(numbers[stack.peek()] < numbers[i+1]){
                        int temp = stack.pop();
                        result[temp] = numbers[i+1];
                    } else {
                        break;
                    }
                }
            }
        }
        return result;
    }
}
