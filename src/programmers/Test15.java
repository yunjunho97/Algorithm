package programmers;

import java.util.HashMap;

public class Test15 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 1, 4}));
    }

    public static int solution(int[] topping){
        int answer = 0;

        HashMap<Integer, Integer> leftMap = new HashMap<>();
        HashMap<Integer, Integer> rightMap = new HashMap<>();

        for(int x : topping){
            rightMap.put(x, rightMap.getOrDefault(x, 0) + 1);
        }
        //i를 포함해서 왼쪽, 미포함 오른쪽
        for(int i = 0; i < topping.length; i++){
            //왼쪽맵에 넣고 put getOrDefault +1
            leftMap.put(topping[i], leftMap.getOrDefault(topping[i], 0) + 1);

            //오른쪽맵에서 빼고 put get -1 == 0 이면 key삭제
            int temp = rightMap.get(topping[i]);
            if(temp == 1){
                rightMap.remove(topping[i]);
            } else {
                rightMap.put(topping[i], temp-1);
            }

            //map.size로 종류의 개수 판단
            if(leftMap.size() == rightMap.size()) answer++;
        }

        return answer;
    }
}
