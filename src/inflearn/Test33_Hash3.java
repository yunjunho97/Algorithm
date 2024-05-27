package inflearn;

import java.util.HashMap;
import java.util.Scanner;

public class Test33_Hash3 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] list = new int[n];
        for(int i = 0; i < n; i++){
            list[i] = in.nextInt();
        }
        int[] answer = solution(n, k, list);
        for(int x : answer){
            System.out.print(x + " ");
        }
    }

    //input
    //7 4
    //20 12 20 10 23 17 10

    //hashmap + sliding window
    public static int[] solution(int n, int k, int[] list){
        int[] answer = new int[n-k+1]; //4
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < k; i++){ //0123
            map.put(list[i], map.getOrDefault(list[i], 0) + 1);
        }
        answer[0] = map.size();

        for(int i = k; i < n; i++){ //4 - 7
            map.put(list[i-k], map.get(list[i-k]) - 1);
            if(map.get(list[i-k]) == 0){
                map.remove(list[i-k]);
            }
            map.put(list[i], map.getOrDefault(list[i], 0) + 1);
            answer[i-k+1] = map.size();
        }

        return answer;
    }
}
