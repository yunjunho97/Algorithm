package programmers_level3;

import java.util.LinkedList;
import java.util.Queue;

public class Test3 {
    public static void main(String[] args) {
        int n = 10;
        int[] tops = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println(solution(n, tops));
    }

    public static int solution(int n, int[] tops){
        n = n*2 + 1;
        for(int i : tops) n += i;
        int[] arr = new int[n+1];
        int p = 1;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < tops.length; i++){
            if(tops[i] == 1) {
                p += 3;
                queue.add(p);
            } else {
                p += 2;
            }
        }

        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;
        for(int i = 4; i <= n; i++){
            if(!queue.isEmpty() && i == queue.peek()) {
                arr[i] = (arr[i-1] + arr[i-3]) % 10007;
                queue.poll();
            } else {
                arr[i] = (arr[i-1] + arr[i-2]) % 10007;
            }
        }
        return arr[n];
    }
}
