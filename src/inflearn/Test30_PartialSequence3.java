package inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test30_PartialSequence3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] list = new int[n];
        for(int i = 0; i < n; i++){
            list[i] =in.nextInt();
        }
        System.out.println(solution(n, k, list));
    }

    public static int solution(int n, int k, int[] list){
        int answer = 0;

        int countZero = 0; //지금까지 나온 0의 개수
        int holdZero = -1; //가장 먼저 나온 0의 위치
        Queue<Integer> queue = new LinkedList<>();

        int sum = 0;
        for(int i = 0; i < n; i++){
            if(list[i] == 0){ //0을 만나면 개수를 1 증가 시키고 큐에 위치를 저장
                countZero++;
                queue.add(i);
            }
            if(countZero > k){ //0의 개수가 허용치를 초과하면 큐에서 0의 위치를 반환
                holdZero = queue.poll();
                countZero--; // 0의 개수 1 감소
            }
            sum = i - holdZero; //현재 i 위치에서, 0으로 바뀐 위치까지의 차이가 연속된 1의 개수
            answer = Math.max(answer, sum);
        }

        return answer;
    }
}
