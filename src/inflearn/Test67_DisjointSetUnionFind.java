package inflearn;

import java.util.Scanner;

public class Test67_DisjointSetUnionFind {
    //인덱스번호 = 학생번호, 배열값 = 집합의 번호
    //1[1], 2[2], 3[3], ...
    static int[] unf;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int studentNumber = in.nextInt(); //학생의 수
        int m = in.nextInt(); //순서쌍의 개수

        //각 학생번호마다 집합번호를 부여해서 초기화
        unf = new int[studentNumber+1];
        for(int i = 1; i <= studentNumber; i++) unf[i] = i;

        for(int i = 0; i < m; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            Union(a, b); //a와 b를 한 집합으로 만들어라
        }
        int target1 = in.nextInt();
        int target2 = in.nextInt();
        int fa = Find(target1);
        int fb = Find(target2);
        if(fa == fb) System.out.println("YES");
        else System.out.println("NO");
    }

    public static int Find(int v){
        if(v == unf[v]) return v; //v번 학생의 집합 번호를 리턴
        else return unf[v] = Find(unf[v]); //연결된 노드를 찾는 동시에 경로 압축
    }

    public static void Union(int a, int b){
        int fa = Find(a);
        int fb = Find(b);
        if(fa != fb) unf[fa] = fb;
    }
}
