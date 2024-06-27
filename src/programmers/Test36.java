package programmers;

import java.util.*;

public class Test36 {
    //90+20
    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210",
                "python frontend senior chicken 150","cpp backend senior pizza 260",
                "java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250","- and backend and senior and - 150",
                "- and - and - and chicken 100","- and - and - and - 150"};
        System.out.println(Arrays.toString(solution(info, query)));
    }

    public static int[] solution(String[] info, String[] query){
        int[] answer = new int[query.length];
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        for(String str : info){
            String[] strArr = str.split(" ");
            String key = strArr[0] + strArr[1] + strArr[2] + strArr[3];
            int value = Integer.parseInt(strArr[4]);
            ArrayList<Integer> list = map.getOrDefault(key, new ArrayList<>());
            list.add(value);
            map.put(key, list);
        }
        for(String key : map.keySet()){
            Collections.sort(map.get(key), (o1, o2) -> o2 - o1);
        }

        for(int i = 0; i < answer.length; i++){
            int count = 0;
            String str = query[i];
            int score = Integer.parseInt(str.split(" ")[7]);
            Set<String> keySet = makeKeySet(str, map.keySet());
            for(String key : keySet){
                count += calculateByBinarySearch(score, map.get(key));
            }
            answer[i] = count;
        }
        return answer;
    }
    public static Set<String> makeKeySet(String query, Set<String> keySet){
        Set<String> set = new HashSet<>(keySet);
        String[] strArr = query.split(" ");
        for(int i = 0; i <= 6; i+=2){
            if(strArr[i].equals("-")) continue;
            Iterator<String> iterator = set.iterator();
            while(iterator.hasNext()){
                if(!iterator.next().contains(strArr[i])) iterator.remove();
            }
        }
        return set;
    }
//    public static int calculate(int score, ArrayList<Integer> list){
//        int count = 0;
//        for(int num : list){
//            if(num >= score) count++;
//            else break;
//        }
//        return count;
//    }
    public static int calculateByBinarySearch(int score, ArrayList<Integer> list){
        int left = 0;
        int right = list.size()-1;
        while(left <= right) {
            int center = (left + right) / 2;
            if(list.get(center) < score){
                right = center - 1;
            } else {
                left = center + 1;
            }
        }
        return left;
    }
}
