package programmers;

public class Test77 {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(solution(arr));
    }

    public static int solution(int[] arr){
        if(arr.length == 1) return arr[0];
        int result = lcm(arr[0], arr[1]);
        for(int i = 2; i < arr.length; i++){
            result = lcm(result, arr[i]);
        }
        return result;
    }

    public static int gcd(int a, int b){
        if(a % b == 0) return b;
        return gcd(b, a%b);
    }

    public static int lcm(int a, int b){
        return (a * b) / gcd(a, b);
    }
}
