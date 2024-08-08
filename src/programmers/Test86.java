package programmers;

public class Test86 {
    public static void main(String[] args) {
        System.out.println(solution(3));
    }

    //그냥 규칙이 보여서 했는데
    //주어진 자연수를 연속된 자연수의 합으로 표현하는 방법의 수는
    //주어진 자연수의 홀수인 약수의 개수와 같다
    //라는 정수론 정리가 있음
    public static int solution(int n) {
        int answer = 0;
        for(int i = 1; i <= n; i+=2){
            if(n % i == 0) answer++;
        }
        return answer;
    }
}
