package programmers;

import java.util.Arrays;

public class Test64 {
    public static void main(String[] args) {
        String[] phone_book = {"119", "976 74223", "1195524421"};
        System.out.println(solution(phone_book));
    }

    public static boolean solution(String[] phone_book){
        Arrays.sort(phone_book);
        for(int i = 0; i < phone_book.length-1; i++) {
            if(phone_book[i+1].replace(" ", "")
                    .startsWith(phone_book[i].replace(" ", ""))) return false;
        }
        return true;
    }
}
