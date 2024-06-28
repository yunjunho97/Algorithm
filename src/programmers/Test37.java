package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Test37 {
    //60
    static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args) {
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2,3,4};
        System.out.println(Arrays.toString(solution(orders, course)));
    }

    public static String[] solution(String[] orders, int[] course){
        ArrayList<String> answer = new ArrayList<>();
        for(int length : course){
            HashMap<String, Integer> map = new HashMap<>();
            int max = 0;
            for(String order : orders){
                recursive(0, "", 0, length, sort(order));
                for(String key : list) {
                    int num = map.getOrDefault(key, 0)+1;
                    map.put(key, num);
                    max = Math.max(max, num);
                }
                list.clear();
            }
            if(!map.isEmpty() && max >= 2) {
                answer.addAll(calculate(map, max));
            }
        }

        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }

    public static void recursive(int l, String temp, int count, int length, String order){
        if(count == length) {
            list.add(temp);
            return;
        }
        if(l == order.length()) return;

        recursive(l+1, temp+order.charAt(l), count+1, length, order);
        recursive(l+1, temp, count, length, order);
    }

    public static ArrayList<String> calculate(HashMap<String, Integer> map, int max){
        ArrayList<String> keyList = new ArrayList<>();

        for(String key : map.keySet()){
            if(map.get(key) == max) keyList.add(key);
        }
        return keyList;
    }

    public static String sort(String str){
        char[] c = str.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
}
