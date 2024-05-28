package inflearn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class Test35_TreeSet {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();
        int[] list = new int[n];
        for(int i = 0; i < n; i++){
            list[i] = in.nextInt();
        }
        System.out.println(solution(n, t, list));
        System.out.println(solution2(n, t, list));
    }

    public static int solution(int n, int t, int[] list){
        int answer = -1;

        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i = 0; i < list.length; i++){
            int num1 = list[i];
            for(int j = i+1; j < list.length; j++){
                int num2 = list[j];
                for(int k = j+1; k < list.length; k++){
                    int num3 = list[k];
                    arrayList.add(num1+num2+num3);
                }
            }
        }
        Collections.sort(arrayList, Collections.reverseOrder());
        int max = 1000;
        int count = 0;
        for(int i : arrayList){
            if(max > i){
                max = i;
                count++;
            }
            if(count == t){
                answer = max;
            }
        }

        return answer;
    }

    //TreeSet
    //중복제거, 정렬
    //레드블랙트리 균형잡힌 이진트리
    public static int solution2(int n, int k, int[] list){
        int answer = -1;

        //오름차순
        //TreeSet<Integer> Tset = new TreeSet<>();

        //내림차순
        TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder());

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                for(int l = j+1; l < n; l++){
                    Tset.add(list[i] + list[j] + list[l]);
                }
            }
        }

        int count = 0;
        for(int x : Tset){
            count++;
            if(count == k){
                return x;
            }
        }

        return answer;
    }
}
