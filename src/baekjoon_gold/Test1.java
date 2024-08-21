package baekjoon_gold;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i = 0; i < T; i++){
            int N = in.nextInt();
            int K = in.nextInt();
            int[] buildTime = new int[N];
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
            for(int j = 0; j < N; j++){
                buildTime[j] = in.nextInt();
                map.put(j, new ArrayList<>());
            }
            for(int j = 0; j < K; j++){
                int first = in.nextInt()-1;
                int next = in.nextInt()-1;
                map.get(next).add(first);
            }
            int want = in.nextInt()-1;
            System.out.println(solution(map, buildTime, want));
        }
    }
    //l을 지으려면 w가 필요함
    public static int solution(HashMap<Integer, ArrayList<Integer>> map, int[] buildTime, int want){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(want);
        int max = buildTime[want];

        int[] dp = Arrays.copyOf(buildTime, buildTime.length);

        while(!queue.isEmpty()){
            int key = queue.poll();
            for(int precede : map.get(key)) {
                if(dp[precede] < dp[key] + buildTime[precede]) {
                    dp[precede] = dp[key] + buildTime[precede];
                    max = Math.max(max, dp[precede]);
                    queue.add(precede);
                }
            }
        }

        return max;
    }
}
