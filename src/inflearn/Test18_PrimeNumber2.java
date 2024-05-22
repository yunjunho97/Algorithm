package inflearn;

public class Test18_PrimeNumber2 {
    public static void main(String[] args) {
        int n = 9;
        int[] list = {32, 55, 62, 20, 250, 370, 200, 30, 100};
//        System.out.println(solution(n, list));
        solution2(4);
    }

    public static String solution(int n, int[] list){
        String answer = "";
        for(int i = 0; i < n; i++){
            String a = String.valueOf(list[i]);
            String b = new StringBuilder(a).reverse().toString();
            int c = Integer.parseInt(b);
            int flag = 0;
            for(int j = 2; j < (c/2); j++){
                if(c % j == 0){
                    flag = 1;
                    break;
                }
            }
            if(flag == 0 && c != 1){
                answer += c + " ";
            }
        }
        return answer;
    }

    //tmp = n                   res = 0
    //t = tmp % 10              res = res * 10 + t
    //tmp = tmp / 10
    public static void solution2(int n){
        int tmp = n;
        int t = 0;
        int res = 0;
        while(tmp > 0){
            t = tmp % 10;
            res = (res * 10) + t;
            tmp = tmp / 10;
        }
        System.out.println(res);
    }
}
