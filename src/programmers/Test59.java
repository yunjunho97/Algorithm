package programmers;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Test59 {
    public static void main(String[] args) {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        System.out.println(solution(priorities, location));
    }

    public static int solution(int[] priorities, int location){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Node59> queue = new LinkedList<>();

        for(int i : priorities){
            priorityQueue.add(i);
        }
        for(int i = 0; i < priorities.length; i++){
            int target = 0;
            if(i == location) target = 1;
            queue.add(new Node59(target, priorities[i]));
        }

        int answer = 0;
        while(!priorityQueue.isEmpty()){
            int flag = priorityQueue.poll();
            while(true){
                Node59 temp = queue.poll();
                if(temp.target == 1 && temp.priority == flag) return answer+1;
                if(temp.priority == flag) {
                    answer++;
                    break;
                } else {
                    queue.add(temp);
                }
            }
        }
        return 0;
    }
}
class Node59{
    int target;
    int priority;
    public Node59(int target, int priority){
        this.target = target;
        this.priority = priority;
    }
}