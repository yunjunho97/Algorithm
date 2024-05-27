package inflearn;

import java.util.HashMap;
import java.util.Scanner;

public class Test32_Hash2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();
        System.out.println(solution(a, b));
    }

    //아나그램: 문자열에 사용된 각각의 문자들에 대해 개수가 동일하고 배치만 다른경우
    public static String solution(String a, String b){
        HashMap<Character, Integer> mapA = new HashMap<>();
        HashMap<Character, Integer> mapB = new HashMap<>();
        for(char c : a.toCharArray()){
            mapA.put(c, mapA.getOrDefault(c, 0) + 1);
        }
        for(char c : b.toCharArray()){
            mapB.put(c, mapB.getOrDefault(c, 0) + 1);
        }

        //key의 value가 다르면 아나그램이 아님
        for(char key : mapA.keySet()){
            if(mapA.get(key) != mapB.getOrDefault(key, -1)){
                return "NO";
            } else {
                mapB.remove(key); //key의 value가 같은 경우에 mapB에서 해당키를 삭제
            }
        }

        //아나그램이라면 위 반복문을 마치고 mapB에 아무것도 없어야 함
        if(mapB.size() != 0){
            return "NO";
        }

        return "YES";
    }
}
