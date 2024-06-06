package inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class Test52_MaxDistance {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int horse = in.nextInt();
        int[] list = new int[n];
        for(int i = 0; i < n; i++){
            list[i] = in.nextInt();
        }
        System.out.println(solution(list, horse));
    }

    public static int solution(int[] list, int horse){
        //1 2 4 8 9
        //1 ~ 8 4
        //1 ~ 3 2
        //3 ~ 3 3
        Arrays.sort(list);
        int lt = list[1] - list[0];
        int rt = list[list.length-1] - list[0];
        int ct = (rt + lt) / 2;
        int answer = -1;
        while(lt <= rt){
            int count = horse-1;
            int i = 1;
            for(int j = 1; j < horse; j++){ //말 한마리씩 넣기
                int sum = 0;
                while(sum < ct && i < list.length){
                    sum += list[i] - list[i-1];
                    i++;
                }
                if(sum < ct){
                    break;
                }
                count--;
            }
            if(count == 0){
                answer = ct;
                lt = ct + 1;
                ct = (rt + lt) / 2;
            } else {
                rt = ct - 1;
                ct = (rt + lt) / 2;
            }
        }
        return answer;
    }

}
