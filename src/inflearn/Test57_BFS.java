package inflearn;

import java.util.*;

public class Test57_BFS {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] coins = new int[n];
        for(int i = n-1; i >=0 ; i--){
            coins[i] = in.nextInt();
        }
        int target = in.nextInt();

        System.out.println(solution(coins, target));
    }

    public static int solution(int[] coins, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        map.put(0, 0);
        queue.add(0);
        while(!queue.isEmpty()){
            int temp = queue.poll();
            int count = map.get(temp);
            if(temp == target) return count;
            for(int i = 0; i < coins.length; i++){
                if(queue.contains(temp + coins[i])){
                    map.put(temp + coins[i],
                            Math.min(map.getOrDefault(temp + coins[i], Integer.MAX_VALUE), count) + 1);
                } else {
                    queue.add(temp + coins[i]);
                    map.put(temp + coins[i],
                            Math.min(map.getOrDefault(temp + coins[i], Integer.MAX_VALUE), count) + 1);
                }
            }
        }
        return -1;
    }
}
