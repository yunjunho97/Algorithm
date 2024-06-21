package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Test23 {
    public static void main(String[] args) {
        int n = 2;
        int[] info = {1,1,0,0,0,0,0,0,0,0,0};
        System.out.println(Arrays.toString(solution2(n, info)));
    }

    public static int[] solution(int n, int[] info){
        int[] result = new int[11];
        int sumA = 0;
        //[점수, 코스트, 1발당 기대값]
        PriorityQueue<double[]> queue = new PriorityQueue<>((o1, o2) -> Double.compare(o2[2],o1[2]));
        for(int i = 0; i < info.length; i++){
            double score = 10-i;
            double cost = info[i]+1;
            double expectedValue = score / cost;
            if(info[i] > 0){
                sumA += (int)score;
                expectedValue *= 2;
            }
            queue.offer(new double[] {score, cost, expectedValue});
        }
        int remainArrows = n;
        int sum = 0;
        while(!queue.isEmpty() && remainArrows > 0){
            double[] temp = queue.poll();
            if(temp[1] <= remainArrows){
                remainArrows -= temp[1];
                sum += (int)temp[0];
                if(temp[1] > 1){
                    sumA -= (int)temp[0];
                }
                result[10-(int)temp[0]] = (int)temp[1];
            }
        }
        if(remainArrows > 0){
            result[10] += remainArrows;
        }
        if(sum > sumA){
            return result;
        } else {
            return new int[]{-1};
        }
    }

    public static int[] solution2(int n, int[] info){
        PriorityQueue<Node23> queue = new PriorityQueue<>(
                (o1, o2) -> Double.compare(o2.expect, o1.expect));

        int sumA = 0;
        for(int i = 0; i < info.length; i++){
            sumA += (10-i) * Math.min(1, info[i]);
            queue.add(new Node23(10-i, info[i]+1));
        }

        int sumB = 0;
        int remain = n;
        int[] result = new int[info.length];
        while(!queue.isEmpty() && remain > 0){
            Node23 temp = queue.poll();
            if(temp.count > remain) continue;
            remain -= temp.count;
            result[10-temp.point] = temp.count;
            sumB += temp.point;
            sumA -= temp.point * Math.min(1, temp.count-1);
        }

        if(remain > 0) result[10] += remain;
        System.out.println(sumA + " " + sumB);
        if(sumB > sumA) return result;
        else return new int[]{-1};
    }

    public static void solution3(int n, int[] info){
        for(int i = 0; i < info.length; i++){

        }
    }
}
class Node23{
    int point;
    int count;
    double expect;
    public Node23(int point, int count){
        this.point = point;
        this.count = count;
        if(count > 1) {
            this.expect = (double)(point * 2) / count;
        } else {
            this.expect = (double)point / count;
        }
    }
}
