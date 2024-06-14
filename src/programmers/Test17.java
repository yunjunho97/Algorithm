package programmers;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Test17 {
    public static void main(String[] args) {
        int[] elements = {7,9,1,1,4};
        System.out.println(solution(elements));
    }

    public static int solution(int[] elements){
        Set<Integer> set = new HashSet<>();

        for(int i = 1; i <= elements.length; i++){
            int sum = 0;
            for(int k = 0; k < i; k++){
                sum += elements[k];
            }
            set.add(sum);
            for(int j = i; j < elements.length+i-1; j++){
                sum += elements[j%elements.length];
                sum -= elements[(j-i)%elements.length];
                set.add(sum);
            }
        }
        return set.size();
    }
}
