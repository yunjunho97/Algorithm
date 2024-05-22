package inflearn;

import java.util.Scanner;

public class Test19_Score {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int[] list = new int[n];
        for(int i = 0; i < n; i++){
            list[i] = in.nextInt();
        }
        System.out.println(solution(n, list));
    }

    //list: 1이면 정답, 0이면 오답
    //연속해서 맞추면 점수증가치 1씩 증가
    //오답이면 점수증가치 초기화
    public static int solution(int n, int[] list){
        int answer = 0;
        int count = 0;
        for(int i = 0; i < n; i++){
            if(list[i] == 1){
                count++;
                answer += count;
            } else{
                count = 0;
            }
        }

        return answer;
    }
}
