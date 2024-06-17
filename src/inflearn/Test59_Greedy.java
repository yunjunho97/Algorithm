package inflearn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Test59_Greedy {
    public static void main(String[] args) {
        ArrayList<Integer[]> list = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            list.add(new Integer[]{in.nextInt(), in.nextInt()});
        }
        System.out.println(solution(list));
    }

    //greedy 현재에서 최선의 선택을 하면서 나아간다
    //dp 현재 선택이 나중에 보니 최선의 선택이 아니었던 발목잡는 경우
    public static int solution(ArrayList<Integer[]> list){
        int answer = list.size();
        Collections.sort(list, (o1, o2) -> o2[0] - o1[0]);
        int max = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i)[1] > max){
                max = list.get(i)[1];
            } else {
                answer--;
            }
        }
        return answer;
    }
}
