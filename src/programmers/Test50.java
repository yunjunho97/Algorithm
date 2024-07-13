package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Test50 {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234",
                "Enter uid1234 Prodo","Change uid4567 Ryan"};

        System.out.println(Arrays.toString(solution(record)));
    }

    public static String[] solution(String[] record){
        HashMap<String, String> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();

        for(String s : record){
            String[] arr = s.split(" ");
            String type = arr[0];
            if(type.equals("Enter")){
                map.put(arr[1], arr[2]);
                list.add(arr[1] + " 님이 들어왔습니다.");
            } else if(type.equals("Leave")){
                list.add(arr[1] + " 님이 나갔습니다.");
            } else if(type.equals("Change")){
                map.put(arr[1], arr[2]);
            }
        }

        for(String s : list){
            String[] arr = s.split(" ");
            String id = arr[0];
            String name = map.get(id);
            String len = name + "님이 " + arr[2];
            result.add(len);
        }

        String[] answer = new String[result.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = result.get(i);
        }

        return answer;
    }
}
