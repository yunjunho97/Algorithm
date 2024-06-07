package programmers;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}};
        System.out.println(solution(board));
    }

    public static int solution(int[][] board){
        //n개의 시추공 포인트에 대해 각 포인트에서 채굴 가능한 석유의 총량을 저장
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < board[0].length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[j][i] == 1){ //방문한적 없는 석유가 발견되면
                    Dump2 dump2 = recursive(new int[] {j, i}, board); //연결된 덩어리 탐색 메서드
                    int sum = dump2.sum;
                    TreeSet<Integer> access = dump2.access;
                    board = dump2.board;
                    //메서드 실행후 해당 덩어리에 access가능한 포인트들의 총량값을 갱신
                    for(int x : access){
                        map.put(x, map.getOrDefault(x, 0) + sum);
                    }
                }
            }
        }
        int max = 0;
        for(int value : map.values()){
            max = Math.max(max, value);
        }
        return max;
    }

    //시작점으로 부터 연결된 모든 지점을 탐색
    public static Dump2 recursive(int[] start, int[][] board){
        int sum = 1; //이 석유 덩어리의 총 량
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        TreeSet<Integer> access = new TreeSet<>(); //이 석유 덩어리에 닿을수 있는 시추공의 위치들
        Stack<int[]> stack = new Stack<>();
        stack.push(start);
        board[start[0]][start[1]] = 2;
        access.add(start[1]);
        while(!stack.isEmpty()){
            int[] position = stack.pop();
            for(int i = 0; i < 4; i++){
                if(0 <= position[1]+dx[i] && position[1]+dx[i] < board[0].length &&
                0 <= position[0]+dy[i] && position[0]+dy[i] < board.length){
                    if(board[position[0]+dy[i]][position[1]+dx[i]] == 1){
                        board[position[0]+dy[i]][position[1]+dx[i]] = 2; //방문한 지점을 2로 체크
                        stack.push(new int[]{position[0]+dy[i], position[1]+dx[i]});
                        //석유의 위치의 x값을 시추공이 access가능한 값으로 추가해줌
                        access.add(position[1]+dx[i]);
                        sum++; //석유 덩어리의 총량 +1
                    }
                }
            }
        }
        Dump2 dump2 = new Dump2(sum, board, access);
        return dump2;
    }
}
class Dump2{
    int sum; //이 석유 덩어리의 총 량
    int[][] board; //board를 업데이트 하기
    TreeSet<Integer> access; //이 석유 덩어리에 닿을수 있는 시추공의 위치들
    Dump2(int sum, int[][] board, TreeSet<Integer> access){
        this.sum = sum;
        this.board = board;
        this.access = access;
    }
}
