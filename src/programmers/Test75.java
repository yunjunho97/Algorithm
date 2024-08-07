package programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Test75 {
    public static void main(String[] args) {
        int N = 3;
        int K = 2;
        int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        int[][] road2 = {{1,2,1},{2,3,1},{1,3,5}};
        System.out.println(solution(N, road2, K));
    }

    public static int solution(int N, int[][] road, int K){
        int[][] board = new int[N][N];
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < road.length; i++) {
            int node1 = road[i][0] - 1;
            int node2 = road[i][1] - 1;
            int cost = road[i][2];
            if (cost < board[node1][node2]) {
                board[node1][node2] = cost;
                board[node2][node1] = cost;
            }
        }

        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.add(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentNode = current[0];
            int currentDist = current[1];

            if (currentDist > dist[currentNode]) continue;

            for (int i = 0; i < N; i++) {
                if (board[currentNode][i] != Integer.MAX_VALUE) {
                    int newDist = currentDist + board[currentNode][i];
                    if (newDist < dist[i]) {
                        dist[i] = newDist;
                        pq.add(new int[]{i, newDist});
                    }
                }
            }
        }

        int answer = 0;
        for (int i : dist) {
            if (i <= K) answer++;
        }
        return answer;
    }
}
