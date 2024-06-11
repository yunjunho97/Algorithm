package programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Test9 {
    static int sign=0; //최대 회원수
    static int earn=0; //최대 수익
    public static void main(String[] args) {
        int[] a = solution(new int[][]{{40, 10000},{25, 10000}}, new int[]{7000, 9000});
        System.out.println(Arrays.toString(a));
    }

    public static int[] solution(int[][] users, int[] emoticons){
        int[] answer = new int[2]; //결과값

        int[] arr = new int[emoticons.length]; //할인율

        comb(arr, 0, users, emoticons); //이모티콘이 할인되는 모든 분기를 탐색

        answer[0] = sign;
        answer[1] = earn;

        return answer;
    }
    public static void comb(int[] arr, int start, int[][] users, int[] emoticons){
        if(start == arr.length){
            calculate(arr, users, emoticons);
            return;
        }

        for(int i = 10; i <= 40; i+=10){
            arr[start] = i;
            comb(arr, start+1, users, emoticons);
        }
    }
    public static void calculate(int[] arr, int[][] users, int[] emoticons){
        int count = 0; //해당 이모티콘 할인율에 대한 회원수
        int earn_t = 0; //해당 이모티콘 할인율에 대한 수익

        for(int[] user : users){
            int discount = user[0]; //해당 유저가 구매하는 할인율 기준
            int price = user[1]; //해당 유저가 가입하는 가격 기준
            int sum = 0; //해당 유저가 지불하는 총 가격
            for(int i = 0; i < arr.length; i++){
                if(arr[i] >= discount) {
                    sum+=(emoticons[i]/100)*(100-arr[i]);
                }
            }
            if(sum >= price){
                count++;
            } else {
                earn_t += sum;
            }
        }

        if(count > sign){
            sign = count;
            earn = earn_t;
        } else if(count == sign){
            if(earn_t > earn){
                earn = earn_t;
            }
        }
    }
}
