package programmers;

public class Test84 {
    public static void main(String[] args) {

    }

    public static String solution(String s){
        String[] arr = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(String str : arr){
            max = Math.max(max, Integer.parseInt(str));
            min = Math.min(min, Integer.parseInt(str));
        }
        return String.valueOf(min) + " " + String.valueOf(max);
    }
}
