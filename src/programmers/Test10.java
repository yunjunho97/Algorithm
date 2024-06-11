package programmers;

public class Test10 {
    public static void main(String[] args) {
        int storey = 655;
        System.out.println(solution(storey));
    }

    public static int solution(int storey){
        //0,1,2,3,4면 -하고 6,7,8,9면 +
        int answer = 0;
        while(storey > 0){
            int temp = storey % 10; //일의 자리 숫자
            if(temp < 5){
                answer += temp; //마법의 돌 사용횟수
                storey -= temp; //변수 갱신
                storey /= 10; //일의자리 버리고 모두 한칸씩 오른쪽으로 이동
            } else if(temp > 5) {
                answer += (10 - temp);
                storey += (10 - temp);
                storey /= 10;
            } else { //5일때는 바로 윗 자릿수가 뭔지 확인을 해야함
                if((storey % 100) - 5 >= 50){
                    answer += (10 - temp);
                    storey += (10 - temp);
                    storey /= 10;
                } else {
                    answer += temp;
                    storey -= temp;
                    storey /= 10;
                }
            }
        }
        return answer;
    }
}
