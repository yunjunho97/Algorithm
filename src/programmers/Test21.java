package programmers;

import java.util.HashMap;

public class Test21 {
    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice"
                , "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        System.out.println(solution(want, number, discount));
    }

    public static int solution(String[] want, int[] number, String[] discount){
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < want.length; i++){
            map.put(want[i], number[i]);
        }

        for(int i = 0; i < 10; i++){
            if(map.containsKey(discount[i])) map.put(discount[i], map.get(discount[i]) - 1);
        }
        int flag2 = 0;
        for(int value : map.values()){
            if(value > 0) {
                flag2 = 0;
                break;
            }
            flag2 = 1;
        }
        if(flag2 == 1){
            answer++;
        }

        for(int i = 10; i < discount.length; i++){
            if(map.containsKey(discount[i])) map.put(discount[i], map.get(discount[i]) - 1);
            if(map.containsKey(discount[i-10])) map.put(discount[i-10], map.get(discount[i-10]) + 1);
            int flag = 0;
            for(int value : map.values()){
                if(value > 0) {
                    flag = 0;
                    break;
                }
                flag = 1;
            }
            if(flag == 1){
                answer++;
            }
        }
        return answer;
    }
}
