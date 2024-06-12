package inflearn;

import java.util.Scanner;

public class Test54 {
    static boolean flag = false;
    static int total;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }
        solution(arr);
        if(flag) System.out.println("YES");
        else System.out.println("NO");
    }

    public static void solution(int[] arr){
        total = 0; //배열 전체의 합
        for(int x : arr){
            total += x;
        }
        solution2(0, 0, arr);
    }
    public static void solution2(int l, int sum, int[] arr){
        if(total-sum == sum) flag = true; //전체합의 절반이면 성공

        if(flag) return; //성공한 뒤 스택에 남아있는 함수들 다 리턴
        if(l == arr.length) return; //배열의 끝까지 가면 리턴

        solution2(l+1, sum + arr[l], arr); //인덱스 l의 수를 더하는 경우
        solution2(l+1, sum, arr); //인덱스 l의 수를 더하지 않는 경우
    }
}
