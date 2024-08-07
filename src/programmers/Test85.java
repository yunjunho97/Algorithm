package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class Test85 {
    static int[] result;
    static int count = 0;
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution2(3, 5)));
    }

    //k번째 까지 모든 순열을 계산(비효율적)
    public static int[] solution(int n, long k){
        int[] check = new int[n];
        int[] arr = new int[n];
        result = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = i+1;
        }
        recursive(0, check, arr, k-1);
        return result;
    }

    public static boolean recursive(int l, int[] check, int[] arr, long k){
        if(l == arr.length) {
            if(count == k) return false;
            else {
                count++;
                return true;
            }
        }

        for(int i = 0; i < arr.length; i++){
            if(check[i] == 1) continue;
            result[l] = arr[i];
            check[i] = 1;
            if(!recursive(l+1, check, arr, k)) {
                return false;
            }
            check[i] = 0;
            result[l] = 0;
        }

        return true;
    }

    public static int[] solution2(int n, long k){
        int[] answer = new int[n];
        long factorial = 1;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(i+1);
            factorial *= (i+1);
        }
        k--;
        for(int i = 0; i < n; i++){
            factorial /= n-i;
            int index = (int)(k / factorial);
            answer[i] = list.get(index);
            list.remove(index);
            k %= factorial;
        }
        return answer;
    }
}
