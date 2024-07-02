package programmers;

public class Test43 {
    //1 11
    public static void main(String[] args) {
        System.out.println(solution(1,2));
    }

    public static long solution(int w, int h){
        if(w == h){
            return ((long)w * (long)h) - w;
        }

        long result = 0;
        int a = Math.min(w, h);
        int b = Math.max(w, h);
        double c = (double)a / b;

        int temp = -1;
        for(int i = 1; i <= b-1; i++){
            if((c * i) % 1 != 0){
                if((int)(c * i) != temp){
                    result += 2;
                    temp = (int)(c * i);
                } else {
                    result += 1;
                }
            }
        }
        long answer = ((long)w * (long)h) - result;
        return answer;
    }
}
