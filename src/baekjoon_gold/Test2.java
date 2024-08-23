package baekjoon_gold;

import java.util.ArrayList;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[][] robots = new int[N][2];
        int[][] homes = new int[N][2];
        for(int i = 0; i < N; i++){
            robots[i][0] = in.nextInt();
            robots[i][1] = in.nextInt();
        }
        for(int i = 0; i < N; i++){
            homes[i][0] = in.nextInt();
            homes[i][1] = in.nextInt();
        }
        solution(N, robots, homes);
    }

    public static void solution(int N, int[][] robots, int[][] homes){
        ArrayList<Node2> list = new ArrayList<>();
        int[] check = new int[N];
        recursive(0, robots, homes, list, check);
        for(Node2 node2: list){
            System.out.println(node2.flag + 1);
        }
    }

    public static boolean recursive(int l, int[][] robots, int[][] homes, ArrayList<Node2> list, int[] check){
        if(l == robots.length) return true;

        int[] xy1 = robots[l];
        for(int j = 0; j < homes.length; j++){
            if(check[j] == 1) continue;
            int[] xy2 = homes[j];
            Node2 node2 = new Node2(xy1[0], xy1[1], xy2[0], xy2[1], j);
            if(!isCrash(list, node2)) {
                check[j] = 1;
                list.add(node2);
                if(recursive(l+1, robots, homes, list, check)) return true;
                check[j] = 0;
                list.remove(node2);
            }
        }
        return false;
    }

    public static boolean isCrash(ArrayList<Node2> list, Node2 node2) {
        for(Node2 preNode : list) {
            if(isIntersect(preNode, node2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isIntersect(Node2 line1, Node2 line2) {
        int o1 = CCW(line1.x1, line1.y1, line1.x2, line1.y2, line2.x1, line2.y1);
        int o2 = CCW(line1.x1, line1.y1, line1.x2, line1.y2, line2.x2, line2.y2);
        int o3 = CCW(line2.x1, line2.y1, line2.x2, line2.y2, line1.x1, line1.y1);
        int o4 = CCW(line2.x1, line2.y1, line2.x2, line2.y2, line1.x2, line1.y2);

        if(o1 != o2 && o3 != o4) return true;

        return (o1 == 0 && onSegment(line1.x1, line1.y1, line1.x2, line1.y2, line2.x1, line2.y1)) ||
                (o2 == 0 && onSegment(line1.x1, line1.y1, line1.x2, line1.y2, line2.x2, line2.y2)) ||
                (o3 == 0 && onSegment(line2.x1, line2.y1, line2.x2, line2.y2, line1.x1, line1.y1)) ||
                (o4 == 0 && onSegment(line2.x1, line2.y1, line2.x2, line2.y2, line1.x2, line1.y2));
    }

    public static boolean onSegment(int x1, int y1, int x2, int y2, int x, int y) {
        return x <= Math.max(x1, x2) && x >= Math.min(x1, x2) && y <= Math.max(y1, y2) && y >= Math.min(y1, y2);
    }

    public static int CCW(int x1, int y1, int x2, int y2, int x3, int y3) {
        int result = (x1*y2 + x2*y3 + x3*y1) - (x2*y1 + x3*y2 + x1*y3);
        if(result > 0) return 1;
        else if(result < 0) return -1;
        else return 0;
    }
}
class Node2 {
    int flag;
    int x1;
    int y1;
    int x2;
    int y2;
    Node2(int x1, int y1, int x2, int y2, int flag) {
        if(x1 <= x2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        } else {
            this.x1 = x2;
            this.y1 = y2;
            this.x2 = x1;
            this.y2 = y1;
        }
        this.flag = flag;
    }
}
