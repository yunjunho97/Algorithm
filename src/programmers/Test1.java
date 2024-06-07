package programmers;

import java.util.*;
import java.util.stream.IntStream;

public class Test1 {
    public static void main(String[] args) {
        int[][] list2 = {{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, {4, 3}, {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}};
        System.out.println(Arrays.toString(solution(list2)));

    }

    //그래프들이 여러개 있고, 노드 하나(중심노드)를 추가해서 모든 그래프들의 아무 노드에 연결시킴
    public static int[] solution(int[][] edges) {
        int donut = 0; //도넛 그래프의 개수
        int stick = 0; //막대 그래프의 개수
        int eight = 0; //8자 그래프의 개수

        //key: 노드번호, value: 갈 수 있는 모든 노드들
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        TreeSet<Integer> trash = new TreeSet<>(); //중심 노드가 될 수 없는 노드들
        for(int i = 0; i < edges.length; i++){
            //입력에 대해 HashMap을 구성
            ArrayList<Integer> getList = map.getOrDefault(edges[i][0], new ArrayList<>());
            getList.add(edges[i][1]);
            map.put(edges[i][0], getList);
            trash.add(edges[i][1]); //중심 노드가 될 수 없는 노드면 trash에 추가
        }

        //중심 노드가 될 수 있는 노드들 중 갈수있는곳의 개수가 가장 많은것이 중심 노드임
        Map.Entry<Integer, ArrayList<Integer>> maxEntry = null;
        for(Map.Entry<Integer, ArrayList<Integer>> entry: map.entrySet()){
            if(trash.contains(entry.getKey())){
                continue;
            }
            if(maxEntry == null || entry.getValue().size() > maxEntry.getValue().size()){
                maxEntry = entry;
            }
        }

        //각각의 그래프가 무슨 그래프인지 알아내기
        for(int x : maxEntry.getValue()){
            int start = x;
            while(true){
                if(map.get(x) == null){ //다른곳으로 갈수없는 노드가 발견되면 막대 그래프
                    stick++;
                    break;
                } else if(map.get(x).size() == 2){ //두 곳으로 갈수있는 노드가 발견되면 8자 그래프
                    eight++;
                    break;
                } else{ //한 곳으로 갈수있는 노드면
                    x = map.get(x).get(0); //일단 거기로 감
                    if(x == start){ //근데 가다보니 처음 노드로 되돌아 오면 도넛 그래프
                        donut++;
                        break;
                    }
                }
            }
        }
        int[] arr = {maxEntry.getKey(), donut, stick, eight};
        return arr;
    }
}
