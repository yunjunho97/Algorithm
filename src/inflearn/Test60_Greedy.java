package inflearn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Test60_Greedy {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Node60> list = new ArrayList<>();
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            list.add(new Node60('s', in.nextInt()));
            list.add(new Node60('e', in.nextInt()));
        }
        System.out.println(solution(list));
    }

    public static int solution(ArrayList<Node60> list){
        int answer = 0;
        Collections.sort(list, (o1, o2) -> {
            if(o1.time == o2.time){
                return o1.flag - o2.flag;
            }
            return o1.time - o2.time;
        });

        int sum = 0;
        for(Node60 node60 : list){
            if(node60.flag == 's') sum++;
            else sum--;
            if(sum > answer) answer = sum;
        }
        return answer;
    }
}

class Node60{
    char flag;
    int time;
    Node60(char flag, int time){
        this.flag = flag;
        this.time = time;
    }
}