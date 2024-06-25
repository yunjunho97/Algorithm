package programmers;

import java.util.HashMap;

public class Test30 {
    static int[] unf;
    public static void main(String[] args) {
        int n = 3;
        int[][] wires = {{1,2},{2,3},{3,4}};
        int[][] wires2 = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        System.out.println(solution(9, wires2));
    }

    public static int solution(int n, int[][] wires){
        int min = Integer.MAX_VALUE;
        unf = new int[n+1];
        for(int j = 0; j < wires.length; j++){
            initUnf();
            for(int i = 0; i < wires.length; i++){
                if(i == j) continue;
                Union(wires[i][0], wires[i][1]);
            }
            int diff = calculate();
            min = Math.min(min, diff);
        }
        return min;
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
    public static void initUnf(){
        for(int i = 0; i < unf.length; i++){
            unf[i] = i;
        }
    }
    public static int calculate(){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 1; i < unf.length; i++){
            int key = Find(i);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int[] temp = new int[2];
        int p = 0;
        for(int value : map.values()){
            temp[p] = value;
            p++;
        }
        return Math.abs(temp[0] - temp[1]);
    }
}
