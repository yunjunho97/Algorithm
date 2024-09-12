package programmers_level3;

import java.util.*;

public class Test10 {
    public static void main(String[] args) {
        int[][] scores = {{2,2},{1,4},{3,2},{3,2},{2,1}};
        System.out.println(solution(scores));
    }

    public static int solution(int[][] scores) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for(int[] score : scores) {
            if(!map.containsKey(score[0])) {
                map.put(score[0], new ArrayList<>());
            }
            map.get(score[0]).add(score[1]);
        }

        for(ArrayList<Integer> list : map.values()) {
            Collections.sort(list);
        }

        List<Integer> list = new ArrayList<>(map.keySet()); //key
        Collections.sort(list, Collections.reverseOrder());

        HashMap<Integer, Integer> rankMap = new HashMap<>(); //점수, 인원

        int max = map.get(list.get(0)).get(map.get(list.get(0)).size()-1);

        for(int score : map.get(list.get(0))) {
            rankMap.put(list.get(0) + score, rankMap.getOrDefault(list.get(0) + score, 0) + 1);
        }

        for(int i = 1; i < list.size(); i++) {
            ArrayList<Integer> temp = map.get(list.get(i));
            Iterator<Integer> iterator = temp.iterator();
            while(iterator.hasNext()) {
                int scoreRight = iterator.next();
                if(scoreRight < max) {
                    iterator.remove();
                } else {
                    rankMap.put(list.get(i) + scoreRight, rankMap.getOrDefault(list.get(i) + scoreRight, 0) + 1);
                    max = scoreRight;
                }
            }
        }

        if(!map.get(scores[0][0]).contains(scores[0][1])) return -1;

        int target = scores[0][0] + scores[0][1];
        int rank = 1;
        for(int key : rankMap.keySet()) {
            if(key <= target) continue;
            rank += rankMap.get(key);
        }

        return rank;
    }
}
