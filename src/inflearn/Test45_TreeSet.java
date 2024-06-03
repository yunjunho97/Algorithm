package inflearn;

import java.util.Scanner;
import java.util.TreeSet;

public class Test45_TreeSet {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] list = new int[n];
        for(int i = 0; i < n; i++){
            list[i] = in.nextInt();
        }
        System.out.println(solution(n, list));
    }

    //문자열에 중복된 문자가 있는지 확인
    public static char solution(int n, int[] list){

        //TreeSet으로 중복제거후 배열과 set의 크기 비교
        TreeSet<Integer> set = new TreeSet<>();
        for(int num : list){
            set.add(num);
        }
        if(list.length == set.size()){
            return 'U';
        } else {
            return 'D';
        }
    }
}
