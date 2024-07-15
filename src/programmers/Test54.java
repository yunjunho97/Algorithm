package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class Test54 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(24,24)));
    }

    public static int[] solution(int brown, int yellow){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= Math.sqrt(yellow); i++){
            if(yellow % i == 0){
                list.add(i);
                list.add(yellow / i);
            }
        }
        int[] answer = new int[2];
        for(int i = 0; i < list.size(); i+=2){
            if((list.get(i) * 2) + (list.get(i+1) * 2) + 4 == brown) {
                answer[1] = list.get(i)+2;
                answer[0] = list.get(i+1)+2;
                break;
            }
        }
        return answer;
    }
}
