package programmers;

public class Test27 {
    static int max = 0;
    static int[] check;
    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80,20},{50,40},{30,10}};
        int[][] a = {{90,20}};
        System.out.println(solution(k, a));
    }

    public static int solution(int k, int[][] dungeons){
        check = new int[k];
        recursive(k, dungeons, 0);
        return max;
    }

    public static void recursive(int k, int[][] dungeons, int count){
        if(k < 0) return;
        if(count > max) max = count;
        for(int i = 0; i < dungeons.length; i++){
            if(check[i] == 1) continue;
            if(k >= dungeons[i][0]){
                check[i] = 1;
                recursive(k-dungeons[i][1], dungeons, count+1);
                check[i] = 0;
            }
        }
    }
}
