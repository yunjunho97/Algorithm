package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Test49 {
    static ArrayList<String> temp;
    public static void main(String[] args) {
        String[][] relation = {{"a", "1", "aaa", "c", "ng"},
                {"b", "1", "bbb", "c", "g"},
                {"c", "1", "aaa", "d", "ng"},
                {"d", "2", "bbb", "d", "ng"}};
        System.out.println(solution(relation));
    }

    public static int solution(String[][] relation){
        int answer = 0;
        ArrayList<String> used = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 1; i <= relation[0].length; i++){
            temp = new ArrayList<>();
            candidateList("", 0, used, i, relation[0].length);
            System.out.println(temp);
            for(int j = 0; j < temp.size(); j++){
                String can = temp.get(j);
                if(!check2(used, can)) continue;
                char[] cArr = can.toCharArray();
                int[] arr = new int[cArr.length];
                for(int k = 0; k < arr.length; k++){
                    arr[k] = cArr[k] - 48;
                }
                if(check(relation, arr, map) == 1){
                    answer++;
                    used.add(can);
                }
                map.clear();
            }
        }
        System.out.println(used);
        return answer;
    }

    public static boolean check2(ArrayList<String> used, String can){
        for(String s : used){
            Set<Character> set = new HashSet<>();
            for(char c : s.toCharArray()) set.add(c);
            int sum = 0;
            for(char c : can.toCharArray()){
                if(!set.add(c)) sum++;
            }
            if(sum == s.length()) return false;
        }
        return true;
    }

    public static int check(String[][] strArr, int[] intArr, HashMap<String, Integer> map){
        for(String[] row : strArr){
            String key = "";
            for(int k : intArr){
                key += row[k] + " ";
            }
            if(!map.containsKey(key)) map.put(key, 1);
            else return 0;
        }
        return 1;
    }

    public static void candidateList(String can, int l, ArrayList<String> used, int num, int arrLength){
        if(can.length() == num) {
            temp.add(can);
            return;
        }
        if(l == arrLength) return;

        candidateList(can+l, l+1, used, num, arrLength);
        candidateList(can, l+1, used, num, arrLength);
    }
}
