package inflearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Test26_CommonElements {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] listN = new int[n];
        for(int i = 0; i < n; i++){
            listN[i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] listM = new int[m];
        for(int i = 0; i < m; i++){
            listM[i] = in.nextInt();
        }
        ArrayList<Integer> answer = solution(n, listN, m, listM);
        for(int i = 0; i < answer.size(); i++){
            System.out.print(answer.get(i) + " ");
        }
    }

    //두 집합의 공통 원소 구하기
    public static ArrayList<Integer> solution(int n, int[] listN, int m, int[] listM){
        ArrayList<Integer> answer = new ArrayList<>();

        int counterN = 0;
        int counterM = 0;

        //전처리로 각 배열 오름차순으로 정렬
        Arrays.sort(listN);
        Arrays.sort(listM);

        while(counterN < n && counterM < m){
            if(listN[counterN] == listM[counterM]){
                answer.add(listN[counterN]);
                counterN++;
                counterM++;
            } else if(listN[counterN] > listM[counterM]){
                counterM++;
            } else{
                counterN++;
            }
        }

        return answer;
    }
}
