package programmers;

public class Test45 {
    public static void main(String[] args) {
        System.out.println(solution("abababababababababab"));
    }
    //90
    public static int solution(String s){
        int answer = s.length();
        char[] arr = s.toCharArray();
        for(int i = 1; i < s.length(); i++){
            String before = "";
            String now = "";
            int sum = 0;
            int flag = 0;
            int init = 10;
            for(int j = 0; j < arr.length; j++){
                now += arr[j];
                if((j+1) % i == 0){
                    if(now.equals(before)) {
                        flag += 1;
                    } else {
                        init = 10;
                        flag = 1;
                        before = now;
                        sum += i;
                    }
                    if(flag == 2) sum++;
                    if(flag % init == 0) {
                        sum++;
                        init *= 10;
                    }
                    now = "";
                }
            }
            if(now.length() < i) sum += now.length();
            answer = Math.min(answer, sum);
        }
        return answer;
    }
}
