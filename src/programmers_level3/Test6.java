package programmers_level3;

public class Test6 {
    public static void main(String[] args) {
        int temperature = -10;
        int t1 = -5;
        int t2 = 5;
        int a = 5;
        int b = 1;
        int[] onboard = {0, 0, 0, 0, 0, 1, 0};
        System.out.println(solution(temperature, t1, t2, a, b, onboard));
    }

    public static int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        //데이터 전처리
        temperature += 11;
        t1 += 11;
        t2 += 11;

        //l 시간, w 온도
        int[][] dp = new int[onboard.length][51];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        dp[0][temperature] = 0;

        int answer = 0;

        if(temperature > t2){
            for(int l = 1; l < dp.length; l++){
                for(int w = 0; w < dp[0].length; w++){
                    int temp = Integer.MAX_VALUE;
                    if((onboard[l] == 1 && (w < t1 || w > t2))){
                        continue;
                    }
                    if(w-1 >= 0 && dp[l-1][w-1] != -1){
                        temp = Math.min(temp, dp[l-1][w-1]);
                    }
                    if(dp[l-1][w] != -1) {
                        temp = Math.min(temp, dp[l-1][w] + b);
                    }
                    if(w+1 < dp[0].length && dp[l-1][w+1] != -1){
                        temp = Math.min(temp, dp[l-1][w+1] + a);
                    }
                    if(temp != Integer.MAX_VALUE){
                        dp[l][w] = temp;
                    }
                }
            }
            answer = dp[dp.length-1][t2];
        } else {
            for(int l = 1; l < dp.length; l++){
                for(int w = 0; w < dp[0].length; w++){
                    int temp = Integer.MAX_VALUE;
                    if((onboard[l] == 1 && (w < t1 || w > t2))){
                        continue;
                    }
                    if(w-1 >= 0 && dp[l-1][w-1] != -1){
                        temp = Math.min(temp, dp[l-1][w-1] + a);
                    }
                    if(dp[l-1][w] != -1){
                        temp = Math.min(temp, dp[l-1][w] + b);
                    }
                    if(w+1 < dp[0].length && dp[l-1][w+1] != -1){
                        temp = Math.min(temp, dp[l-1][w+1]);
                    }
                    if(temp != Integer.MAX_VALUE){
                        dp[l][w] = temp;
                    }
                }
            }
            answer = dp[dp.length-1][t1-1];
        }
        return answer;
    }
}
