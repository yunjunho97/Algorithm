package programmers;

public class Test26 {
    public static void main(String[] args) {
        for(int i = 1; i < 10000; i++){
            for(int j = 3; j <= 10; j++){
                System.out.println(solution(i, j));
            }
        }
    }

    public static int solution(int n, int k){
        String num = Integer.toString(n, k);
        char[] arr = num.toCharArray();
        String temp = "";
        int answer = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == '0'){
                if(temp.isEmpty()) continue;
                if(isPrime(Long.parseLong(temp))) answer++;
                temp = "";
            } else {
                temp += arr[i];
            }
        }
        if(!temp.isEmpty() && isPrime(Long.parseLong(temp))) answer++;
        return answer;
    }

    public static boolean isPrime(long n){
        if(n == 1) return false;
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0) return false;
        }
        return true;
    }
}
