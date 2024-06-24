package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Test25 {
    public static void main(String[] args) {
        //35분 +20
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        System.out.println(Arrays.toString(solution(fees, records)));
    }
    public static int[] solution(int[] fees, String[] records){
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> result = new HashMap<>();
        for(String record : records){
            int hour = Integer.parseInt(record.split(" ")[0].split(":")[0]) * 60;
            int minuit = Integer.parseInt(record.split(" ")[0].split(":")[1]);
            int time = hour + minuit;
            int number = Integer.parseInt(record.split(" ")[1]);

            if(!map.containsKey(number)) {
                map.put(number, time);
            } else {
                int startTime = map.get(number);
                result.put(number, result.getOrDefault(number, 0) + (time - startTime));
                map.remove(number);
            }
        }
        for(int number : map.keySet()){
            int startTime = map.get(number);
            int endTime = 1439;
            result.put(number, result.getOrDefault(number, 0) + (endTime - startTime));
        }

        ArrayList<Integer> keyList = new ArrayList<>(result.keySet());
        Collections.sort(keyList, (o1, o2) -> o1 - o2);
        int[] answer = new int[result.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = calculate(fees, result.get(keyList.get(i)));
        }
        return answer;
    }

    public static int calculate(int[] fees, int time){
        if(time <= fees[0]) return fees[1];
        else {
            time -= fees[0];
            int mul = (int)Math.ceil((double)time / fees[2]);
            return fees[1] + (mul * fees[3]);
        }
    }
}
