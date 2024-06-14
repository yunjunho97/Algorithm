package programmers;

import java.util.Stack;

public class Test16 {
    public static void main(String[] args) {
        int[] list = {5, 4, 3, 2, 1};
        System.out.println(solution(list));
    }
    public static int solution(int[] order){
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        int pointerOrder = 0; //트럭에 실어야 하는 순서
        int pointerContainer = 1; //컨테이너 벨트의 순서
        while(pointerOrder < order.length){
            //컨테이너 벨트에 지금 실어야 하는게 있는경우
            if(order[pointerOrder] == pointerContainer){
                pointerOrder++;
                pointerContainer++;
                answer++;
            } else if(!stack.isEmpty() && stack.peek() == order[pointerOrder]) {//스택에 있는 경우
                stack.pop();
                pointerOrder++;
                answer++;
            } else if(pointerContainer <= order.length) { //둘다 없는 경우
                stack.push(pointerContainer);
                pointerContainer++;
            } else {
                break;
            }
        }
        return answer;
    }
}
