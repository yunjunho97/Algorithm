package programmers;

import java.util.Arrays;

public class Test33 {
    public static void main(String[] args) {
        long[] numbers = {2,7};
        System.out.println(Arrays.toString(solution(numbers)));
    }

    public static long[] solution(long[] numbers){
        long[] answer = new long[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            answer[i] = calculate(numbers[i]);
        }
        return answer;
    }

    public static long calculate(long number){
        //짝수면 바로 다음 수를 리턴
        if((number & 1L) == 0) return number+1;

        //홀수라면 오른쪽끝부터 가장 먼저 나오는 0의 위치를 찾고
        //그 위치를 1로 바꿔주고 바로 오른쪽은 0으로 바꿔줌 <- 오른쪽에 비트1 을 더해주면 됨
        long mask = 1L;
        while((number & mask) != 0) mask <<= 1;
        return number + (mask >> 1);
    }
}
