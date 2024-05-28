package library_memo;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HashMap_memo {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 10);
        map.put(2, 30);
        map.put(3, 20);

        //반복문 사용
        Map.Entry<Integer, Integer> maxEntry = null;

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(maxEntry == null || entry.getValue() > maxEntry.getValue()){
                maxEntry = entry;
            }
        }

        System.out.println(maxEntry.getKey() + " " + maxEntry.getValue());

        //getOrDefault
        System.out.println(map.get(4)); //null
        System.out.println(map.getOrDefault(4, 0)); //0

        //containsKey
        System.out.println(map.containsKey(3)); //true
        System.out.println(map.containsKey(4)); //false

        //size
        System.out.println(map.size()); //3 맵의 사이즈

        //remove
        System.out.println(map.remove(3)); //20 삭제되는 key의 value를 리턴
        System.out.println(map.size()); //2

        //
        int maxKey = Collections.max(map.keySet());
        System.out.println(maxKey);

        int maxValue = Collections.max(map.values());
        System.out.println(maxValue);
    }
}
