package programmers_level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Test1 {
    static ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    static ArrayList<Integer> winScore = new ArrayList<>();
    public static void main(String[] args) {
        int[][] dices = {{1, 2, 3, 4, 5, 6}, {3, 3, 3, 3, 4, 4}, {1, 3, 3, 4, 4, 4}, {1, 1, 4, 4, 5, 5}};
        int[][] dices2 = {{1, 2, 3, 4, 5, 6}, {2, 2, 4, 4, 6, 6}};
        int[][] dices3 = {{40, 41, 42, 43, 44, 45}, {43, 43, 42, 42, 41, 41}, {1, 1, 80, 80, 80, 80},{70, 70, 1, 1, 70, 70}};
        System.out.println(Arrays.toString(solution(dices)));
    }

    public static int[] solution(int[][] dice){
        ArrayList<Integer> list = new ArrayList<>();
        int[] arr = new int[dice.length];
        for(int i = 0; i < arr.length; i++){
            arr[i] = i;
        }
        recursive(0, list, arr);

        for(ArrayList<Integer> comList : result){
            compare(comList, dice, arr);
        }

        int maxScore = -1;
        int maxId = -1;
        for(int i = 0; i < winScore.size(); i++){
            if(winScore.get(i) > maxScore) {
                maxScore = winScore.get(i);
                maxId = i;
            }
        }

        int[] answer = new int[dice.length/2];
        for(int i = 0; i < answer.length; i++){
            answer[i] = result.get(maxId).get(i) + 1;
        }
        return answer;
    }

    public static void compare(ArrayList<Integer> list, int[][] dice, int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> map1 = new HashMap<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            if(list.contains(i)) continue;
            list1.add(i);
        }

        for(int i = 0; i < 6; i++){
            map.put(dice[list.get(0)][i], map.getOrDefault(dice[list.get(0)][i], 0) + 1);
            map1.put(dice[list1.get(0)][i], map1.getOrDefault(dice[list1.get(0)][i], 0) + 1);
        }

        ArrayList<Integer> clist = new ArrayList<>(list);
        ArrayList<Integer> clist1 = new ArrayList<>(list1);
        clist.remove(0);
        clist1.remove(0);

        for(int i = 0; i < arr.length; i++){
            if(clist.contains(i)){
                HashMap<Integer, Integer> temp = new HashMap<>();
                for(Integer key : map.keySet()) {
                    for(int j = 0; j < 6; j++){
                        temp.put(key + dice[i][j], temp.getOrDefault(key + dice[i][j], 0) + map.get(key));
                    }
                }
                map = temp;
            } else if(clist1.contains(i)){
                HashMap<Integer, Integer> temp = new HashMap<>();
                for(Integer key : map1.keySet()){
                    for(int j = 0; j < 6; j++){
                        temp.put(key + dice[i][j], temp.getOrDefault(key + dice[i][j], 0) + map1.get(key));
                    }
                }
                map1 = temp;
            }
        }
        calculate(map, map1);
    }

    public static void calculate(HashMap<Integer, Integer> map1, HashMap<Integer, Integer> map2){
        int score = 0;
        for(Integer key1 : map1.keySet()){
            for(Integer key2 : map2.keySet()){
                if(key1 > key2) {
                    score += map1.get(key1) * map2.get(key2);
                }
            }
        }
        winScore.add(score);
    }

    public static void recursive(int l, ArrayList<Integer> list, int[] arr){
        if(list.size() == arr.length/2) {
            result.add(new ArrayList<>(list));
            return;
        }
        if(l == arr.length) return;

        list.add(arr[l]);
        recursive(l+1, list, arr);
        list.remove(list.size()-1);
        recursive(l+1, list, arr);
    }
}
