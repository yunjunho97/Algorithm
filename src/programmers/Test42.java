package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Test42 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("{{123}}")));
    }

    public static int[] solution(String s){
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i = 1; i < s.length()-1; i++){
            if(s.charAt(i) == '{') {
                ArrayList<Integer> list1 = new ArrayList<>();
                String temp = "";
                while(true) {
                    i++;
                    if (Character.isDigit(s.charAt(i))) {
                        temp += s.charAt(i);
                    } else {
                        list1.add(Integer.parseInt(temp));
                        temp = "";
                        if (s.charAt(i) == '}') break;
                    }
                }
                list.add(new ArrayList<>(list1));
            }
        }
        Collections.sort(list, (o1, o2) -> o1.size() - o2.size());

        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            ArrayList<Integer> temp = list.get(i);
            for(int num : temp) {
                if(!answer.contains(num)) answer.add(num);
            }
        }
        int[] result = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++){
            result[i] = answer.get(i);
        }
        return result;
    }
}
