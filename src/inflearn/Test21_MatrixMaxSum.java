package inflearn;

import java.util.Scanner;

public class Test21_MatrixMaxSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] list = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                list[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(n, list));
        System.out.println(solution2(n, list));
    }

    public static int solution(int n, int[][] list){
        int answer = 0;

        //행
        for(int i = 0; i < list.length; i++){
            int sum = 0;
            for(int j = 0; j < list[i].length; j++){
                sum += list[i][j];
            }
            if(sum > answer){
                answer = sum;
            }
        }
        //열
        for(int i = 0; i < list.length; i++){
            int sum = 0;
            for(int j = 0; j < list[i].length; j++){
                sum += list[j][i];
            }
            if(sum > answer){
                answer = sum;
            }
        }
        //대각선
        for(int i = 0; i < list.length; i++){
            int sum = 0;
            sum += list[i][i];
            if(sum > answer){
                answer = sum;
            }
        }
        //대각선
        for(int i = 0; i < list.length; i++){
            int sum = 0;
            sum += list[i][n-i-1];
            if(sum > answer){
                answer = sum;
            }
        }

        return answer;
    }

    public static int solution2(int n, int[][] list){
        int answer = 0;

        for(int i = 0; i < list.length; i++){
            int sumRow = 0;
            int sumCol = 0;
            for(int j = 0; j < list[i].length; j++){
                sumRow += list[i][j];
                sumCol += list[j][i];
            }
            answer = Math.max(answer, sumRow);
            answer = Math.max(answer, sumCol);
        }

        for(int i = 0; i < list.length; i++){
            int sumLR = 0;
            int sumRL = 0;
            sumLR += list[i][i];
            sumRL += list[i][n-i-1];
            answer = Math.max(answer, sumLR);
            answer = Math.max(answer, sumRL);
        }

        return answer;
    }
}
