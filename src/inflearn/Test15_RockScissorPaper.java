package inflearn;

import java.util.Scanner;

public class Test15_RockScissorPaper {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int count = in.nextInt();
        int[] a = new int[count];
        int[] b = new int[count];
        for(int i = 0; i < count; i++){
            a[i] = in.nextInt();
        }
        for(int i = 0; i < count; i++){
            b[i] = in.nextInt();
        }
        char[] list = solution(count, a, b);
        for(int i = 0; i < count; i++){
            System.out.println(list[i]);
        }
    }
    public static char[] solution(int count, int[] a, int[] b){
        char[] solution = new char[count];

        char[][] table = new char[4][4];
        table[1][1] = 'D';
        table[1][2] = 'B';
        table[1][3] = 'A';
        table[2][1] = 'A';
        table[2][2] = 'D';
        table[2][3] = 'B';
        table[3][1] = 'B';
        table[3][2] = 'A';
        table[3][3] = 'D';

        for(int i = 0; i < count; i++){
            solution[i] = table[a[i]][b[i]];
        }

        return solution;
    }


}
