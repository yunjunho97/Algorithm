package baekjoon_gold;

import java.util.*;

public class Test3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            list.add(in.nextInt());
        }
        solution(list);
    }

    public static void solution(ArrayList<Integer> list) {
        ArrayList<Node3> ready = new ArrayList<>();

        for(int num : list) {
            boolean finish = false;
            for(int i = 0; i < ready.size(); i++){
                int left = ready.get(i).left;
                int right = ready.get(i).right;
                if(num < left) {
                    if(list.stream().anyMatch(o -> num < o && o < left)) {
                        ready.add(i, new Node3(num, num));
                    } else {
                        ready.get(i).left = num;
                    }
                    finish = true;
                    break;
                } else if(num > right) {
                    if(list.stream().noneMatch(o -> right < o && o < num)) {
                        ready.get(i).right = num;
                        finish = true;
                        break;
                    }
                }
            }
            if(!finish) ready.add(new Node3(num, num));
        }

        System.out.println(ready.size());
    }
}
class Node3 {
    int left;
    int right;
    Node3(int left, int right){
        this.left = left;
        this.right = right;
    }
}
