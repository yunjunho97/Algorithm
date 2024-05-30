package inflearn;

import java.util.ArrayList;
import java.util.Scanner;

public class Test44_Cache {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cacheSize = in.nextInt();
        int taskSize = in.nextInt();
        int[] task = new int[taskSize];
        for(int i = 0; i < taskSize; i++){
            task[i] = in.nextInt();
        }
        ArrayList<Integer> list = solution(cacheSize, taskSize, task);
        for(int i : list){
            System.out.print(i + " ");
        }
        System.out.println();
        int[] answer = solution2(cacheSize, taskSize, task);
        for(int i : answer){
            System.out.print(i + " ");
        }
    }

    public static ArrayList<Integer> solution(int cacheSize, int taskSize, int[] task){
        ArrayList<Integer> list = new ArrayList<>();

        for(int i : task){
            for(int j = 0; j < list.size(); j++){
                if(list.get(j) == i){
                    list.remove(j);
                }
            }
            list.add(0, i);
            if(list.size() == cacheSize+1){
                list.remove(list.size()-1);
            }
        }

        return list;
    }

    //배열만 사용
    public static int[] solution2(int cacheSize, int taskSize, int[] taskList){
        int[] cache = new int[cacheSize];

        for(int task : taskList){
            int holdPointer = 0;
            for(int i = 0; i < cacheSize; i++) {
                holdPointer = i;
                if(task == cache[i]){
                    break;
                }
            }
            for(int i = holdPointer-1; i >= 0; i--){
                cache[i+1] = cache[i];
            }
            cache[0] = task;
        }

        return cache;
    }
}
