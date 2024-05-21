package inflearn;

import java.util.Scanner;

public class Test17_PrimeNumber {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int input = in.nextInt();
        System.out.println(solution(input));
    }

    //에라토스테네스 체
    //2부터 n까지 배열을 만들고
    //list[i] == 0이면 소수, list[i의배수]를 다 1로
    public static int solution(int input){
        int answer = 0;
        int[] list = new int[input+1];
        for(int i = 2; i <= input; i++){
            if(list[i] == 0){
                answer++;
                for(int j = i; j <= input; j += i){
                    list[j] = 1;
                }
            }
        }
        return answer;
    }
}
