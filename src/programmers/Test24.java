package programmers;

import java.util.Arrays;

public class Test24 {
    static int dif = 0;
    static int[] answer = new int[11];
    public static void main(String[] args) {
        int n = 3;
        int[] info = {0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1};
        System.out.println(Arrays.toString(solution(n, info)));
    }

    public static int[] solution(int n, int[] info){
        int sumA = 0;
        int sumB = 0;
        for(int i = 0; i < info.length; i++){
            if(info[i] != 0) sumA += (10-i);
        }
        int[] result = new int[info.length];
        recursive(0, n, info, result, sumA, sumB);
        int sum = 0;
        for(int num : answer) sum += num;
        if(sum < n) answer[10] += (n-sum);

        if(dif > 0) return answer;
        else return new int[]{-1};
    }
    public static void recursive(int l, int n, int[] info, int[] result, int sumA, int sumB){
        if(n < 0) return;
        if(dif < sumB - sumA){
            dif = sumB - sumA;
            answer = result.clone();
        } else if(dif == sumB - sumA){
            for(int i = 10; i >= 0; i--){
                if(answer[i] < result[i]) {
                    answer = result.clone();
                    break;
                } else if(answer[i] > result[i]) break;
            }
        }
        if(n == 0) return;
        for(; l < info.length; l++){
            result[l] += info[l]+1;
            sumA -= (10- l) * Math.min(1, info[l]);
            sumB += (10- l);
            recursive(l+1,n-info[l]-1, info, result, sumA, sumB);
            result[l] = 0;
            sumA += (10- l) * Math.min(1, info[l]);
            sumB -= (10- l);
        }
    }
}
