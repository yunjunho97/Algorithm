package inflearn;

import java.util.Scanner;

public class Test71_DP {
    static int[] dy;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        dy = new int[n+1];
        System.out.println(solution(n));
    }

    public static int solution(int n){
        dy[1] = 1;
        dy[2] = 2;
        for(int i = 3; i <= n; i++){
            dy[i] = dy[i-2] + dy[i-1];
        }
        return dy[n];
    }

    //dp bottom-up
    //큰 문제를 작은 단위의 문제로 쪼개고
    //앞에 구해둔 답을 기억해두고 그 다음 문제에 사용한다
    //계단이 1개면 1개다
    //계단이 2개면 2개다

    //뒤에는 계단은 없다 생각하고
    //첫번째 계단에 도달하는 방법은 1가지다 dy[1] = 1
    //두번째 계단에 도달하는 방법은 2가지다 dy[2] = 2
    //여기까지 초기화 해두고

    //세번째 계단으로 오기 위해서는 두번째 계단에서 왔거나, 첫번째 계단에서 온것이다
    //두번째 계단까지 오는 방법의 수 2가지 + 첫번째 계단까지 오는 방법의 수 1가지 = 3가지

    //dy[n] = dy[n-1] + dy[n-2]
}
