package inflearn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Test20_Rank {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] list = new int[n];
        for(int i = 0; i < n; i++) {
            list[i] = in.nextInt();
        }
        list = solution(n, list);
        for(int i = 0; i < n; i++) {
            System.out.print(list[i] + " ");
        }
    }

    public static int[] solution(int n, int[] list){
        int[] answer = new int[n];
        ArrayList<Integer> arr = new ArrayList<>();
        for(int num : list){
            arr.add(num);
        }

        //내림차순으로 정렬
        Collections.sort(arr, Collections.reverseOrder());
        for(int i = 0; i < n; i++){
            int count = 1;
            for(int j = 0; j < n; j++){
                if(list[i] < arr.get(j)){
                    count++;
                } else{ //list[i]보다 작은 수를 만나면
                    answer[i] = count;
                    break;
                }
            }
        }
        return answer;
    }
}
