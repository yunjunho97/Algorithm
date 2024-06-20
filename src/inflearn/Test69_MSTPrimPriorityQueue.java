package inflearn;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Test69_MSTPrimPriorityQueue {
    //정점에서 갈수있는 노드의 간선을 우선순위큐에 넣어줌, cost를 기준으로 오름차순 정렬
    //큐에서 뺀게 방문하지 않은 노드면 선택
    //해당 노드에서 뻗어갈수 있는 노드중 방문하지 않은 노드들을 큐에 저장
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nodesNumber = in.nextInt();
        int edgesNumber = in.nextInt();
        ArrayList<ArrayList<Edge69>> list = new ArrayList<>();
        for(int i = 0; i <= nodesNumber; i++){
            list.add(new ArrayList<Edge69>());
        }
        for(int i = 0; i < edgesNumber; i++){
            int a = in.nextInt(); //시작
            int b = in.nextInt(); //도착
            int c = in.nextInt(); //비용
            list.get(a).add(new Edge69(b, c));
            list.get(b).add(new Edge69(a, c));
        }
        int[] checked = new int[nodesNumber+1];
        PriorityQueue<Edge69> queue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        queue.offer(new Edge69(1, 0));
        int answer = 0;
        while(!queue.isEmpty()){
            Edge69 temp = queue.poll();
            if(checked[temp.node] == 0){
                checked[temp.node] = 1;
                answer += temp.cost;
                for(Edge69 edge : list.get(temp.node)){
                    if(checked[edge.node] == 0) queue.offer(edge);
                }
            }
        }
        System.out.println(answer);
    }
}

class Edge69{
    int node;
    int cost;

    public Edge69(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}

