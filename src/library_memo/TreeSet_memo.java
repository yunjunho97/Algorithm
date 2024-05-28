package library_memo;

import java.util.Collections;
import java.util.TreeSet;

public class TreeSet_memo {
    public static void main(String[] args) {

        //주로 중복 제거를 위해 사용

        //TreeSet 오름차순
        TreeSet<Integer> Tset = new TreeSet<>();

        //TreeSet 내림차순
        TreeSet<Integer> Tset2 = new TreeSet<>(Collections.reverseOrder());

        //add
        for(int i = 0; i < 10; i++){
            Tset.add(i);
            Tset2.add(i);
        }
        System.out.println(Tset);
        System.out.println(Tset2);

        //remove
        Tset.remove(9);
        System.out.println(Tset);

        //size
        System.out.println(Tset.size());

        //first: 제일 앞의 값
        System.out.println(Tset.first());

        //last: 제일 뒤의 값
        System.out.println(Tset.last());

    }
}
