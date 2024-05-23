package inflearn;

import java.util.Scanner;

public class Test24_MentorMentee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //학생수 가로
        int m = sc.nextInt(); //시험수 세로
        int[][] list = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                list[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(n, m, list));
    }

    //맨토-맨티가 되려면 모든 시험에서 맨토가 맨티보다 순위가 높아야 한다
    public static int solution(int n, int m, int[][] list){
        int answer = 0;

        int[][] check = new int[n][n];
        //세로 맨토
        //가로 맨티

        //n 학생수 가로
        //m 시험수 세로
        for(int i = 0; i < m; i++){ //각 시험에 대해
            for(int j = 0; j < n; j++){ //이 학생은
                int std = list[i][j];
                for(int k = j+1; k < n; k++){ //이 학생의 맨토가 될 수 있음을
                    int compare = list[i][k];
                    check[std-1][compare-1] = 1; //표시
                }
            }
        }

        for(int i = 0; i < n; i++){ //표시된 리스트를 돌면서
            for(int j = 0; j < n; j++){
                if(check[i][j] == 1){ //i가 j학생의 맨토가 될 수 있을때
                    if(check[j][i] == 0){ //j는 i학생의 맨토가 될 수 없다면
                        answer++; //맨토-맨티 관계가 성립함
                    }
                }
            }
        }

        return answer;
    }
}
