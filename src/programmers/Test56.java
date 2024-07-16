package programmers;

import java.util.*;

public class Test56 {
    public static void main(String[] args) {
        int[] arr = {0,0};
        System.out.println(solution(arr));
    }

    public static int solution(int[] citations) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for(int i : citations) queue.add(i);
        int pointer = queue.peek();
        int count = 0;
        while(pointer >= 0){
            if(!queue.isEmpty()) {
                if(queue.peek() == pointer) {
                    count++;
                    pointer = queue.poll();
                } else {
                    pointer--;
                }
            } else {
                pointer--;
            }

            if(count == pointer) return pointer;
        }
        return 0;
    }
}
