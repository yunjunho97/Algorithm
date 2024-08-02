package programmers;

public class Test74 {
    public static void main(String[] args) {
        System.out.println(solution(5));
    }

    public static int solution(int n){
        int answer = 0;
        while(n > 0){
            if(n % 2 != 0) {
                n -= 1;
                answer++;
            }
            else n /= 2;
        }
        return answer;
    }
}
