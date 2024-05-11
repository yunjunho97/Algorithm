package inflearn;

import java.util.Scanner;

public class Test1_FindLetter {
    public static void main(String[] args) {
        Test1_FindLetter findLetter = new Test1_FindLetter();

        Scanner in = new Scanner(System.in);

        String str = in.next();
        char c = in.next().charAt(0);
        System.out.print(findLetter.solution(str, c));
    }

    //내가 한것
    public static int solution(String str, char t){
        int answer = 0;
        str = str.toUpperCase();
        t = Character.toUpperCase(t);
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == t){
                answer += 1;
            }
        }

        return answer;
    }

    //풀이
    public static int solution2(String str, char t) {
        int answer = 0;
        str = str.toUpperCase();
        t = Character.toUpperCase(t);
        for(char x : str.toCharArray()){ // toCharArray() String을 문자 배열 객체로 만듬
            if(x == t){
                answer += 1;
            }
        }

        return answer;
    }
}
