package inflearn;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test31_Hash1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String list = in.next();
        System.out.println(solution(n, list));
    }

    //문자열에서 가장 많이 나온 문자 찾기
    //getOrDefault(x, 0) 가져올때 있으면 가져오고 없다면 0으로 가져온다
    public static char solution(int n, String list){
        char answer;

        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : list.toCharArray()){
//            getOrDefault로 수정
//            if(map.get(c) == null){
//                map.put(c, 1);
//            } else{
//                map.put(c, map.get(c) + 1);
//            }
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Map.Entry<Character, Integer> maxEntry = null;
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(maxEntry == null || entry.getValue() > maxEntry.getValue()){
                maxEntry = entry;
            }
        }
        answer = maxEntry.getKey();
        return answer;
    }
}
