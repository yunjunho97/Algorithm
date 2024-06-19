package inflearn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Test68_MSTKruskalUnionFind {
    //그래프: 돌아오는 회로가 존재
    //트리: 회로가 존재하지 않음, 노드가 n 간선이 n-1

    //1. cost를 기준으로 오름차순 정렬
    //2. v1과 v2가 같은 집합이 아니면(Find로 확인)
    //3. cost를 합산하고
    //4. 같은 집합으로 묶기(Union)
    //같은 집합이라면 이미 우리가 만드는 트리에 들어온거고, 여기서 간선이 추가된다면 회로가 되어 버린다

    static int[] unf;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nodesNumber = in.nextInt();
        int edgesNumber = in.nextInt();

        unf = new int[nodesNumber+1];
        for(int i = 0; i < nodesNumber; i++) unf[i] = i;

        ArrayList<Edge68> list = new ArrayList<>();
        for(int i = 0; i < edgesNumber; i++){
            int v1 = in.nextInt();
            int v2 = in.nextInt();
            int cost = in.nextInt();
            list.add(new Edge68(v1, v2, cost));
        }
        Collections.sort(list, (o1, o2) -> o1.cost - o2.cost);

        int sum = 0;
        for(Edge68 node : list){
            int v1 = node.v1;
            int v2 = node.v2;
            int cost = node.cost;
            if(Find(v1) != Find(v2)) {
                sum += cost;
                Union(v1, v2);
            }
            //만약에 간선이 엄청 많이 주어진다면 count를 두고 nodesNumber-1만큼 선택됐을때 break하면 된다
            //보통 그렇게는 잘 안나옴
        }
        System.out.println(sum);
    }
    public static int Find(int v){
        if(v == unf[v]) return v;
        else return unf[v] = Find(unf[v]);
    }

    public static void Union(int a, int b){
        int fa = Find(a);
        int fb = Find(b);
        if(fa != fb) unf[fa] = fb;
    }
}
class Edge68{
    int v1;
    int v2;
    int cost;
    public Edge68(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }
}
