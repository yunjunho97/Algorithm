package programmers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Test7 {
    public static void main(String[] args) {
//        System.out.println(solution(1, 1000000, 1));
        System.out.println(solution3(1, 1000000, 1));
    }

    public static int solution(int x, int y, int n){
        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        queue.add(x);
        map.put(x, 0);
        while(!queue.isEmpty()){
            int temp = queue.poll();
            int count = map.get(temp);
            if(temp == y){
                return count;
            }
            if(temp * 3 <= y){
                if(temp * 3 == y){
                    return count+1;
                }
                if(queue.contains(temp*3)){
                    map.put(temp*3, Math.min(map.getOrDefault(temp*3, Integer.MAX_VALUE), count)+1);
                } else {
                    queue.add(temp*3);
                    map.put(temp*3, Math.min(map.getOrDefault(temp*3, Integer.MAX_VALUE), count)+1);
                }
            }
            if(temp * 2 <= y){
                if(temp * 2 == y){
                    return count+1;
                }
                if(!queue.contains(temp*2)){
                    queue.add(temp*2);
                }
                map.put(temp*2, Math.min(map.getOrDefault(temp*2, Integer.MAX_VALUE), count)+1);
            }
            if(temp + n <= y){
                if(temp + n == y){
                    return count+1;
                }
                if(!queue.contains(temp+n)){
                    queue.add(temp+n);
                }
                map.put(temp+n, Math.min(map.getOrDefault(temp+n, Integer.MAX_VALUE), count)+1);
            }
        }
        return -1;
    }

    public static int solution2(int x, int y, int n){
        HashMap<Integer, Integer> map = new HashMap<>();
        Queue<Node7> queue = new LinkedList<>();
        queue.add(new Node7(x, 0));
        map.put(x, 1);
        while(!queue.isEmpty()){
            Node7 pick = queue.poll();
            if(pick.key == y){
                return pick.count;
            }
            if(pick.key * 3 <= y && !map.containsKey(pick.key * 3)){
                queue.add(new Node7(pick.key * 3, pick.count + 1));
            }
            if(pick.key * 2 <= y && !map.containsKey(pick.key * 2)){
                queue.add(new Node7(pick.key * 2, pick.count + 1));
            }
            if(pick.key + n <= y && !map.containsKey(pick.key + n)){
                queue.add(new Node7(pick.key + n, pick.count + 1));
            }
        }
        return -1;
    }

    public static int solution3(int x, int y, int n){
        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        //BFS, 역순으로
        queue.add(y);
        map.put(y, 0);
        while(!queue.isEmpty()){
            int key = queue.poll();
            int value = map.get(key);
            if(key == x){
                return value;
            }
            if(key % 3 == 0 && !map.containsKey(key/3)){
                queue.add(key / 3);
                map.put(key / 3, value+1);
            }
            if(key % 2 == 0 && !map.containsKey(key/2)){
                queue.add(key / 2);
                map.put(key / 2, value+1);
            }
            if(key - n > 0 && !map.containsKey(key-n)){
                queue.add(key-n);
                map.put(key-n, value+1);
            }
        }
        return -1;
    }
}
class Node7{
    int key;
    int count;
    Node7(int key, int count){
        this.key = key;
        this.count = count;
    }
}
