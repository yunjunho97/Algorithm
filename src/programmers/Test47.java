package programmers;

import java.util.HashMap;

public class Test47 {
    //10
    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_tree = {"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(solution(skill, skill_tree));
    }

    public static int solution(String skill, String[] skill_trees){
        int answer = 0;
        char[] arr = skill.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], i);
        }

        for(String userSkill : skill_trees){
            int pointer = -1;
            char[] userArr = userSkill.toCharArray();
            answer++;
            for(char c : userArr){
                if(map.containsKey(c)) {
                    if(map.get(c) == pointer + 1) pointer = map.get(c);
                    else {
                        answer--;
                        break;
                    }
                }
            }
        }

        return answer;
    }
}
