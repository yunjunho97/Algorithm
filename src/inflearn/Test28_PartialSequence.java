package inflearn;

import java.util.Scanner;

public class Test28_PartialSequence {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int target = in.nextInt();
        int[] list = new int[n];
        for(int i = 0; i < n; i++){
            list[i] = in.nextInt();
        }
        System.out.println(solution(n, target, list));
    }

    //합이 n이 되는 연속부분수열
    public static int solution(int n, int target, int[] list){
        int answer = 0;

        int forwardP = 0;
        int backwardP = 0;

        //초기값 설정
        int sum = list[0];

        while(backwardP < n){
            if(sum < target){ // sum이 target보다 작은데
                if(forwardP == n-1){ // 포인터가 이미 끝까지 왔으면, 어차피 더 해도 target에 도달못함 break
                    break;
                }
                forwardP++; // 앞서는 포인터 증가
                sum += list[forwardP]; // sum에 더하기
            } else if(sum > target){ // sum이 target보다 크면
                sum -= list[backwardP]; // sum에서 뒤따르는 포인터의 값을 빼고
                backwardP++; // 뒤따르는 포인터 증가
            } else{ // sum ==target인데
                answer++;
                if(forwardP == n-1){ //포인터가 이미 끝까지 왔으면, 어차피 더 해도 target에 도달못함 break
                    break;
                }
                forwardP++; // 앞서는 포인터 증가
                sum += list[forwardP]; // sum에 더하기
            }
        }

        return answer;
    }
}
