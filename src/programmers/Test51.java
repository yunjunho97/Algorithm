package programmers;

import java.util.Arrays;

public class Test51 {
    public static void main(String[] args) {
        int[] people = {1,2,8,8,8,8};
        int limit = 10;
        System.out.println(solution(people, limit));
    }

    public static int solution(int[] people, int limit) {
        Arrays.sort(people);
        int answer = 0;
        int left = 0;
        int right = people.length - 1;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            answer++;
        }

        return answer;
    }
}
