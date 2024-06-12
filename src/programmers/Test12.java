package programmers;

import java.util.*;

public class Test12 {
    public static void main(String[] args) {
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
        System.out.println(solution2(6, tangerine));
    }

    public static int solution2(int k, int[] tangerine){
        int answer = 0;

        //key: 귤의 종류 value: 개수
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int x : tangerine){
            map.put(x, map.getOrDefault(x, 0)+1);
        }

        //개수를 기준으로 내림차순으로 정렬
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return Integer.compare(o2.getValue(), o1.getValue());
            }
        });

        //순서대로 개수를 합산해서 합산이 원하는 개수 이상이 될 경우 break
        int sum = 0;
        for(int i = 0; i < list.size(); i++){
            sum += list.get(i).getValue();
            if(sum >= k){
                answer = i+1;
                break;
            }
        }

        return answer;
    }
}
