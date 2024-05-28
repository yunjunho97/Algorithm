package inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test42_Queue2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String target = in.nextLine();
        String all = in.nextLine();
        System.out.println(solution(target, all));
    }

    public static String solution(String target, String all){
        Queue<Character> queue = new LinkedList<>();
        for(char c : target.toCharArray()){
            queue.add(c);
        }
        for(char c : all.toCharArray()){
            if(c == queue.peek()){
                queue.poll();
            }
            if(queue.isEmpty()){
                return "YES";
            }
        }
        return "NO";
    }
}
