package programmers;

public class Test11 {
    static int sum = 0;
    static long targetL;
    static long targetR;
    public static void main(String[] args) {
        solution(20,10,50);
        System.out.println(sum);
    }

    public static int solution(int n, long l, long r){
        targetL = l-1; //어디서부터
        targetR = r-1; //어디까지
        rsolution(0, (long)Math.pow(5, n));
        return sum;
    }

    public static void rsolution(long start, long end){
        long temp = (end - start) / 5; //현재 범위를 5조각으로 쪼갠다

        if(start > targetR) return;
        if(end <= targetL) return;

        //쪼개기를 반복하다가 조각의 크기가 1이 됐을때 더해준다
        //위쪽에서 범위에 벗어나는 조각들에 대해 미리 처리해 주기때문에 여기 도달한 조각은 무조건 1임
        if(end - start == 1){
            sum++;
            return;
        }

        rsolution(start+(temp*0), start+(temp*1));
        rsolution(start+(temp*1), start+(temp*2));
        rsolution(start+(temp*3), start+(temp*4));
        rsolution(start+(temp*4), start+(temp*5));
    }
}
