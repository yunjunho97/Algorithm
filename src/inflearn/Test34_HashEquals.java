package inflearn;

import java.util.HashMap;
import java.util.Scanner;

public class Test34_HashEquals {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String total = in.nextLine();
        String target = in.nextLine();
        System.out.println(solution(total, target));
        System.out.println(solution2(total, target));
    }

    //total에서 target과 아나그램이 되는 부분문자열 개수
    public static int solution(String total, String target){
        int answer = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        for(char key : target.toCharArray()){
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for(int i = 0; i < target.length(); i++){
            if(map.containsKey(total.charAt(i))){
                map.put(total.charAt(i), map.get(total.charAt(i)) - 1);
            }
        }
        int flag = 0;
        for(int value : map.values()){
            if(value != 0){
                flag = 0;
                break;
            }
            flag = 1;
        }
        if(flag == 1){
            flag = 0;
            answer++;
        }

        for(int i = target.length(); i < total.length(); i++){
            if(map.containsKey(total.charAt(i-target.length()))){
                map.put(total.charAt(i-target.length()),
                        map.get(total.charAt(i-target.length())) + 1);
            }
            if(map.containsKey(total.charAt(i))){
                map.put(total.charAt(i), map.get(total.charAt(i)) - 1);
            }
            for(int value : map.values()){
                if(value != 0){
                    flag = 0;
                    break;
                }
                flag = 1;
            }
            if(flag == 1){
                answer++;
                flag = 0;
            }
        }

        return answer;
    }

    //equals 사용 객체끼리의 비교 해쉬맵도 가능하다
    public static int solution2(String total, String target){
        int answer = 0;

        HashMap<Character, Integer> targetMap = new HashMap<>();
        for(char c : target.toCharArray()){
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> totalMap = new HashMap<>();

        for(int i = 0; i < target.length()-1; i++){
            if(targetMap.containsKey(total.charAt(i))){
                totalMap.put(total.charAt(i), totalMap.getOrDefault(total.charAt(i), 0) + 1);
            }
        }

        for(int i = target.length()-1; i < total.length(); i++){
            if(targetMap.containsKey(total.charAt(i))){
                totalMap.put(total.charAt(i), totalMap.getOrDefault(total.charAt(i), 0) + 1);
            }
            if(targetMap.equals(totalMap)){
                answer++;
            }
            if(targetMap.containsKey(total.charAt(i-target.length()+1))){
                totalMap.put(total.charAt(i-target.length()+1),
                        totalMap.get(total.charAt(i-target.length()+1)) - 1);
            }
        }

        return answer;
    }
}
