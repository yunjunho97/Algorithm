package programmers;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Test55 {
    static int[] checked;
    public static void main(String[] args) {
        String numbers = "123";
        System.out.println(solution(numbers));
    }

    public static int solution(String numbers){
        Set<Integer> set = new HashSet<>();
        char[] arr = numbers.toCharArray();
        checked = new int[arr.length];
        recursive("", arr, set);
        int answer = 0;
        for(int i : set){
            if(isPrime(i)) answer++;
        }
        return answer;
    }

    public static void recursive(String num, char[] arr, Set<Integer> set){
        if(!num.isEmpty()) set.add(Integer.parseInt(num));

        for(int i = 0; i < arr.length; i++){
            if(checked[i] == 0) {
                checked[i] = 1;
                recursive(num+arr[i], arr, set);
                checked[i] = 0;
            }
        }
    }

    public static boolean isPrime(int num){
        if(num <= 1) return false;
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}
