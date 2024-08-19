package programmers_level3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Test5 {
    public static void main(String[] args) {
        int[][] maze = {{1, 0, 2}, {0, 0, 0}, {5, 0, 5}, {4, 0, 3}};
        System.out.println(solution(maze));
    }

    public static int solution(int[][] maze){
        int lSize = maze.length;
        int wSize = maze[0].length;

        //[l, w]
        int[] redStart = new int[2];
        int[] blueStart = new int[2];

        for(int l = 0; l < maze.length; l++){
            for(int w = 0; w < maze[0].length; w++){
                if(maze[l][w] == 1){
                    redStart[0] = l;
                    redStart[1] = w;
                } else if(maze[l][w] == 2) {
                    blueStart[0] = l;
                    blueStart[1] = w;
                }
            }
        }
        int[][] visited = new int[lSize][wSize];
        int count = 0;
        boolean complete = false;
        visited[redStart[0]][redStart[1]] = 0b01;
        visited[blueStart[0]][blueStart[1]] = 0b10;
        int[] dl = {0, 0, 1, -1};
        int[] dw = {1, -1, 0, 0};

        Queue<Ball5> queue = new LinkedList<>();
        queue.add(new Ball5(redStart, blueStart, visited, 0));
        while(!queue.isEmpty()){
            Ball5 ball = queue.poll();
            boolean redFinish = (maze[ball.redBall[0]][ball.redBall[1]] == 3);
            boolean blueFinish = (maze[ball.blueBall[0]][ball.blueBall[1]] == 4);
            if(redFinish && blueFinish) {
                complete = true;
                count = ball.count;
                break;
            }
            for(int i = 0; i < 4; i++){
                int[] nextRed = new int[2];
                if(redFinish) {
                    nextRed = Arrays.copyOf(ball.redBall, 2);
                } else {
                    nextRed[0] = ball.redBall[0] + dl[i];
                    nextRed[1] = ball.redBall[1] + dw[i];
                    if(isOutRange(nextRed, lSize, wSize)) continue;
                    if(isPassedBy(0b01, nextRed, ball.visited)) continue;
                }
                for(int j = 0; j < 4; j++){
                    int[] nextBlue = new int[2];
                    if(blueFinish){
                        nextBlue = Arrays.copyOf(ball.blueBall, 2);
                    } else {
                        nextBlue[0] = ball.blueBall[0] + dl[j];
                        nextBlue[1] = ball.blueBall[1] + dw[j];
                        if(isOutRange(nextBlue, lSize, wSize)) continue;
                        if(isPassedBy(0b10, nextBlue, ball.visited)) continue;
                    }
                    if(isConflict(ball.redBall, nextRed, ball.blueBall, nextBlue, maze)) continue;

                    int[][] newVisited = new int[ball.visited.length][];
                    for (int k = 0; k < ball.visited.length; k++) {
                        newVisited[k] = Arrays.copyOf(ball.visited[k], ball.visited[k].length);
                    }
                    newVisited[nextRed[0]][nextRed[1]] |= 0b01;
                    newVisited[nextBlue[0]][nextBlue[1]] |= 0b10;
                    queue.add(new Ball5(nextRed, nextBlue, newVisited, ball.count+1));
                }
            }
        }
        if(!complete) count = 0;
        return count;
    }

    public static boolean isConflict(int[] redPosition, int[] nextRed, int[] bluePosition, int[] nextBlue, int[][] maze){
        if(maze[nextRed[0]][nextRed[1]] == 5 || maze[nextBlue[0]][nextBlue[1]] == 5) return true;
        if(Arrays.equals(nextRed, nextBlue)) return true;
        return (Arrays.equals(redPosition, nextBlue) && Arrays.equals(bluePosition, nextRed));
    }

    public static boolean isOutRange(int[] nextPosition, int lSize, int wSize){
        return (nextPosition[0] < 0 || lSize <= nextPosition[0] || nextPosition[1] < 0 || wSize <= nextPosition[1]);
    }

    public static boolean isPassedBy(int identity, int[] nextPosition, int[][] checked){
        return ((identity & checked[nextPosition[0]][nextPosition[1]]) == identity);
    }
}
class Ball5 {
    int[] redBall;
    int[] blueBall;
    int[][] visited;
    int count;
    Ball5(int[] redBall, int[] blueBall, int[][] visited, int count){
        this.redBall = redBall;
        this.blueBall = blueBall;
        this.visited = visited;
        this.count = count;
    }
}
