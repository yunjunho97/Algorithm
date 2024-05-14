package inflearn;

import java.util.*;

public class Test10_CharDistanceCalculator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(solution(input));
    }

    public static String solution(String inputString){
        String answer = "";
        String strA = inputString.split(" ")[0]; // 대상 문자열
        char target = inputString.split(" ")[1].charAt(0); // 기준이 될 문자
        int[] list = new int[strA.length()]; // 거리값 저장

        int point = inputString.indexOf(target); // 바로 이전의 target위치 - 초기값 설정
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < strA.length(); i++){

            //target과 다른 문자일 경우 큐에 해당 문자의 위치를 저장
            if(strA.charAt(i) != target){
                queue.add(i);
            } else {
                //target을 만났을 경우 모든 큐에 대해
                while(!queue.isEmpty()){
                    int temp = queue.poll();
                    //이전 target의 위치와 현재 target의 위치중 가까운곳을 구해 거리로 저장
                    int des = Math.min(Math.abs(temp - i), Math.abs(temp - point));
                    list[temp] = des;
                }
                point = i;
            }
        }

        //남은 큐들에 대해 가장 최근의 target과의 거리를 저장
        while(!queue.isEmpty()){
            int temp = queue.poll();
            int des = Math.abs(temp - point);
            list[temp] = des;
        }

        //출력 형식을 위한 전처리
        for(int x : list){
            answer += x + " ";
        }

        return answer;
    }
}
