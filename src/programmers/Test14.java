package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Test14 {
    public static HashMap<Integer, Double> map = new HashMap<>();
    public static void main(String[] args) {
        int k = 5;
        int[][] range = {{0,0},{0,-1},{2,-3},{3,-3}};
        System.out.println(Arrays.toString(solution(k, range)));
    }

    public static double[] solution(int k, int[][] range){
        double[] result = new double[range.length];

        ArrayList<Integer> list = calculate(k);

        for(int i = 0; i < range.length; i++){
            int start = range[i][0] + 1;
            int end = range[i][1] + list.size() - 1;
            double sum = size(start, end, list);
            result[i] = sum;
        }

        return result;
    }

    //입력값에 대해 주어진 우박수열 규칙에 따라 list로 생성
    public static ArrayList<Integer> calculate(int k){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(k);
        while(k > 1) {
            if (k % 2 == 0) {
                k /= 2;
            } else {
                k *= 3;
                k += 1;
            }
            list.add(k);
        }
        return list;
    }

    //start부터 end까지 너비의 합
    public static double size(int start, int end, ArrayList<Integer> list){
        double sum = 0;
        //유효하지 않은 입력에 대한 처리
        if(start-1 > end){
            return -1;
        }
        //dx=1 단위로
        //HashMap에 해당 위치의 크기가 있으면 가져오고
        //없다면 계산한 뒤에 HashMap에 저장
        for(; start <= end; start++){
            if(map.containsKey(start)){
                sum += map.get(start);
            } else {
                int min = Math.min(list.get(start-1), list.get(start));
                int max = Math.max(list.get(start-1), list.get(start));
                double temp = min + (double)(max-min) / 2;
                sum += temp;
                map.put(start, temp);
            }
        }
        return sum;
    }
}
