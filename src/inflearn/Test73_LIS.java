package inflearn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Test73_LIS {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Block73> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(new Block73(in.nextInt(), in.nextInt(), in.nextInt()));
        }
        System.out.println(solution(list));
    }

    public static int solution(ArrayList<Block73> list){
        Collections.sort(list, (o1, o2) -> o1.size - o2.size);
        int dy[] = new int[list.size()];
        dy[0] = list.get(0).height;
        int answer = dy[0];
        for(int i = 1; i < list.size(); i++){
            int max = 0;
            for(int j = i-1; j >= 0; j--){
                if(list.get(j).weight <= list.get(i).weight && dy[j] > max) max = dy[j];
            }
            dy[i] = max + list.get(i).height;
            answer = Math.max(answer, dy[i]);
        }
        return answer;
    }
}

class Block73{
    int size;
    int height;
    int weight;
    public Block73(int size, int height, int weight){
        this.size = size;
        this.height = height;
        this.weight = weight;
    }
}
