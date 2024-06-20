package programmers;

import java.util.*;

public class Test19 {
    static int[] unf;
    public static void main(String[] args) {
        //union find
        //find(n)을 map의 키로 나올때마다 value+1

        int[] cards = {8,6,3,7,2,5,1,4};
        System.out.println(solution(cards));
    }

    public static int solution(int[] cards){
        unf = new int[cards.length+1];
        for(int i = 1; i < unf.length; i++){
            unf[i] = i;
        }

        for(int i = 0; i < cards.length; i++){
            Union(i+1, cards[i]);
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < cards.length; i++){
            int key = Find(cards[i]);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int max1 = 0;
        int max2 = 0;
        for(int value : map.values()){
            if(value > max1) {
                max2 = max1;
                max1 = value;
            } else if(value > max2){
                max2 = value;
            }
        }

        return max1 * max2;
    }

    public static int Find(int v){
        if(v == unf[v]) return v;
        else return unf[v] = Find(unf[v]);
    }

    public static void Union(int a, int b){
        int fa = Find(a);
        int fb = Find(b);
        if(fa != fb) unf[fa] = fb;
    }
}
