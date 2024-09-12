package programmers_level3;

public class Test9 {
    public static void main(String[] args) {
        int[] sequence = {2, 3, -6, 1, 3, -1, 2, 4};
        System.out.println(solution(sequence));
    }

    public static long solution(int[] sequence) {
        long[] dpStartPlusOne = new long[sequence.length];
        long[] dpStartMinusOne = new long[sequence.length];

        dpStartPlusOne[0] = sequence[0];
        dpStartMinusOne[0] = sequence[0] * -1;

        long result = Math.max(dpStartPlusOne[0], dpStartMinusOne[0]);

        for(int i = 1; i < sequence.length; i++) {
            int init;
            if(i % 2 == 1) init = -1;
            else init = 1;

            dpStartPlusOne[i] = Math.max(sequence[i] * init, dpStartPlusOne[i-1] + (sequence[i] * init));
            dpStartMinusOne[i] = Math.max(sequence[i] * init * -1, dpStartMinusOne[i-1] + (sequence[i] * init * -1));

            result = Math.max(result, Math.max(dpStartMinusOne[i], dpStartPlusOne[i]));
        }

        return result;
    }
}
