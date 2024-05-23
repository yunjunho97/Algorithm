package inflearn;

import java.util.Scanner;

public class Test25_ArrayMerge {
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

        int[] answer = solution(n, listN, m, listM);

        for(int i : answer){
            System.out.print(i + " ");
        }
    }

    //오름차순의 두 배열을 하나의 오름차순 배열로 병합
    public static int[] solution(int n, int[] listN, int m, int[] listM){
        int[] answer = new int[n+m];

        int pointerN = 0;
        int pointerM = 0;
        int pointerA = 0;

        while(pointerN < n && pointerM < m){
            if(listN[pointerN] < listM[pointerM]){
                answer[pointerA++] = listN[pointerN++];
            } else {
                answer[pointerA++] = listM[pointerM++];
            }
            if(pointerN == n){
                while(pointerM < m){
                    answer[pointerA++] = listM[pointerM++];
                }
                break;
            }
            if(pointerM == m){
                while(pointerN < n){
                    answer[pointerA++] = listN[pointerN++];
                }
                break;
            }
        }

        return answer;
    }
}
