package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test20 {
    public static void main(String[] args) {
        int[] cards = {8,6,3,7,2,5,1,4};
        System.out.println(solution(cards));
    }

    public static int solution(int[] cards){
        boolean[] visited = new boolean[cards.length];
        List<Integer> list= new ArrayList<>();
        list.add(0); //집합이 하나만 나올 경우를 위해 0값을 하나 넣어둠
        int i;
        for(int k = 0; k < cards.length; k++){
            if(visited[k]) continue;

            int sum = 0;
            i = k;
            while(!visited[i]){
                visited[i] = true;
                i = cards[i]-1;
                sum += 1;
            }
            list.add(sum);
        }
        Collections.sort(list, (o1, o2) -> o2 - o1);
        return list.get(0) * list.get(1);
    }
}
