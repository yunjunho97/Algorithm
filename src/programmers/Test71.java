package programmers;

import java.util.HashMap;
import java.util.Iterator;

public class Test71 {
    public static void main(String[] args) {
        System.out.println(solution("handshake", "shake hands"));
    }

    public static int solution(String str1, String str2){
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        StringBuilder temp = new StringBuilder();
        for(int i = 0; i < arr1.length; i++){
            temp.append(Character.toLowerCase(arr1[i]));
            if(temp.length() == 2){
                if(Character.isAlphabetic(temp.charAt(0)) && Character.isAlphabetic(temp.charAt(1))){
                    map1.put(temp.toString(), map1.getOrDefault(temp.toString(), 0) + 1);
                }
                temp.deleteCharAt(0);
            }
        }

        temp = new StringBuilder();
        for(int i = 0; i < arr2.length; i++){
            temp.append(Character.toLowerCase(arr2[i]));
            if(temp.length() == 2){
                if(Character.isAlphabetic(temp.charAt(0)) && Character.isAlphabetic(temp.charAt(1))){
                    map2.put(temp.toString(), map2.getOrDefault(temp.toString(), 0) + 1);
                }
                temp.deleteCharAt(0);
            }
        }

        int min = 0;
        int max = 0;
        Iterator iterator = map1.keySet().iterator();
        while(iterator.hasNext()) {
            String key = iterator.next().toString();
            if(map2.containsKey(key)) {
                min += Math.min(map1.get(key), map2.get(key));
                max += Math.max(map1.get(key), map2.get(key));
                iterator.remove();
                map2.remove(key);
            }
        }

        for(Integer value : map1.values()){
            max += value;
        }
        for(Integer value : map2.values()){
            max += value;
        }
        if(min == 0 && max == 0) return 65536;
        return (int)(((double)min / max) * 65536);
    }
}
