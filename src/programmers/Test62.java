package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Test62 {
    public static void main(String[] args) {
        int bridge_length = 100;
        int weight = 100;
        int[] truck_weight = {10,10,10,10,10,10,10,10,10,10};
        System.out.println(solution(bridge_length, weight, truck_weight));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weight) {
        Queue<Integer> readyQueue = new LinkedList<>();
        Queue<Integer> bridgeQueue = new LinkedList<>();

        for(int i : truck_weight) readyQueue.add(i);

        int timer = 0;
        int nowWeight = 0;
        int counter = truck_weight.length;
        while(counter > 0){
            if(bridgeQueue.size() == bridge_length){
                if(bridgeQueue.peek() == null) bridgeQueue.poll();
                else {
                    nowWeight -= bridgeQueue.poll();
                    counter--;
                }
            }
            if(!readyQueue.isEmpty() && nowWeight + readyQueue.peek() <= weight) {
                nowWeight += readyQueue.peek();
                bridgeQueue.add(readyQueue.poll());
            } else {
                bridgeQueue.add(null);
            }
            timer++;
        }
        return timer;
    }
}
