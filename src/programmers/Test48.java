package programmers;

public class Test48 {
    //8
    static int answer = 0;
    public static void main(String[] args) {
        int[] numbers = {4,1,2,1};
        int target = 4;
        System.out.println(solution(numbers, target));
    }

    public static int solution(int[] numbers, int target){
        recursive(0, 0, numbers, target);
        return answer;
    }

    public static void recursive(int sum, int l, int[] numbers, int target){
        if(l == numbers.length) {
            if(sum == target) answer++;
            return;
        }

        recursive(sum + numbers[l], l+1, numbers, target);
        recursive(sum - numbers[l], l+1, numbers, target);
    }
}
