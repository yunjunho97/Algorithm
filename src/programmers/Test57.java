package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Test57 {
    public static void main(String[] args) {
        int[] numbers = {100};
        System.out.println(solution(numbers));
    }

    public static String solution(int[] numbers){
        ArrayList<String> list = new ArrayList<>();
        for(int i : numbers){
            list.add(Integer.toString(i));
        }
        Collections.sort(list, (o1, o2) -> {
            String a = o1 + o2;
            String b = o2 + o1;
            return b.compareTo(a);
        });

        String answer = "";
        for(String i : list) answer += Integer.valueOf(i);
        if(answer.charAt(0) == '0') answer = "0";
        return answer;
    }

    public static String solution2(int[] numbers){
        String[] nums = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s2 + s1).compareTo(s1 + s2);
            }
        });
        if (nums[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String num : nums) {
            sb.append(num);
        }

        return sb.toString();
    }
}
