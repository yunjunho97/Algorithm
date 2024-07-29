package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Test67 {
    public static void main(String[] args) {
        String msg = "TOBEORNOTTOBEORTOBEORNOT";
        System.out.println(Arrays.toString(solution(msg)));
    }

    public static int[] solution(String msg){
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        int index = 1;
        for(char c = 'A'; c <= 'Z'; c++){
            map.put(String.valueOf(c), index++);
        }

        char[] msgArr = msg.toCharArray();
        int pointer = 0;
        while(pointer < msgArr.length){
            String temp = String.valueOf(msgArr[pointer]);
            String leftTemp = temp;
            while(map.containsKey(temp)) {
                leftTemp = temp;
                pointer++;
                if(pointer == msgArr.length) break;
                temp += msgArr[pointer];
            }
            answer.add(map.get(leftTemp));
            map.put(temp, index++);
        }

        int[] result = new int[answer.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = answer.get(i);
        }
        return result;
    }
}
