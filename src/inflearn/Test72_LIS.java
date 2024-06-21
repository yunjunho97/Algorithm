package inflearn;

import java.util.Scanner;

public class Test72_LIS {
    static int[] dy;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }
        System.out.println(solution(arr));
    }

    public static int solution(int[] arr){
        dy = new int[arr.length];
        dy[0] = 1;
        for(int i = 1; i < arr.length; i++){
            int max = 0;
            for(int j = i-1; j >= 0; j--){
                if(arr[j] < arr[i] && dy[j] > max) max = dy[j];
            }
            dy[i] = max + 1;
        }
        int answer = 0;
        for(int i = 0; i < arr.length; i++){
            if(dy[i] > answer) answer = dy[i];
        }
        return answer;
    }

    //dy[]
    //dy[i]에 대한 정의
    //dy[i]를 마지막 항으로 하면서 만들수 있는 최대 부분증가수열의 길이를 저장
}
