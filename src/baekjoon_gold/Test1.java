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
        HashSet<Integer> set = new HashSet<>();
        set.add(want);
        int max = buildTime[want];

        int[] dp = Arrays.copyOf(buildTime, buildTime.length);

        while(!set.isEmpty()){
            HashSet<Integer> nextSet = new HashSet<>();
            for(int key : set){
                for(int precede : map.get(key)) {
                    dp[precede] = Math.max(dp[precede], dp[key] + buildTime[precede]);
                    max = Math.max(max, dp[precede]);
                    nextSet.add(precede);
                }
            }
            set = nextSet;
        }

        return max;
    }
}
