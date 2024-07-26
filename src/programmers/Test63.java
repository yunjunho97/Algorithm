package programmers;

import java.util.ArrayList;
import java.util.HashMap;

public class Test63 {
    static ArrayList<ArrayList<Integer>> stList = new ArrayList<>();
    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(clothes));
    }

    //모자 2종류, 상의 3종류, 하의 2종류 있을때
    //각각 안입는 경우까지 +1 해서 곱함 -> 3 x 4 x 3
    //마지막에 모두 안입는 경우 1가지 빼줌 -> 36 - 1
    public static int solution2(String[][] clothes){
        HashMap<String, Integer> map = new HashMap<>();

        for(String[] cloth : clothes){
            String key = cloth[1];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int answer = 1;
        for(int i : map.values()) answer *= i+1;

        return answer-1;
    }

    //가능한 모든 조합을 생성, 효율성 안좋음
    public static int solution(String[][] clothes){
        HashMap<String, Integer> map = new HashMap<>();

        for(String[] cloth : clothes){
            String key = cloth[1];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>(map.values());

        ArrayList<Integer> temp = new ArrayList<>();
        recursive(0, temp, list);

        int sum = 0;
        for(ArrayList<Integer> answerList: stList){
            int mul = 1;
            for(int i : answerList) mul *= i;
            sum += mul;
        }

        return sum;
    }

    public static void recursive(int l, ArrayList<Integer> temp, ArrayList<Integer> list){
        temp.add(list.get(l));
        stList.add(new ArrayList<>(temp));

        if(l == list.size()-1) {
            temp.remove(list.get(l));
            return;
        }

        recursive(l+1, temp, list);
        temp.remove(list.get(l));
        recursive(l+1, temp, list);
    }
}
