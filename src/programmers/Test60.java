package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class Test60 {
    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }

    public static int[] solution(int[] progresses, int[] speeds){
        ArrayList<Integer> list = new ArrayList<>();

        int progressPointer = 0;

        while(progressPointer < progresses.length){
            for(int i = progressPointer; i < progresses.length; i++){
                progresses[i] += speeds[i];
            }
            int count = 0;
            while(progressPointer < progresses.length && progresses[progressPointer] >= 100){
                count++;
                progressPointer++;
            }
            if(count > 0) list.add(count);
        }

        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
