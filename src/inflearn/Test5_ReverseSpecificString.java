package inflearn;

import java.util.Scanner;

public class Test5_ReverseSpecificString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputString = scanner.nextLine();
        System.out.println(solution(inputString));
    }

    public static String solution(String inputString) {
        String answer = "";

        int leftPointer = 0;
        int rightPointer = inputString.length()-1;
        char[] chars = inputString.toCharArray();

        while(leftPointer < rightPointer) {

            //왼쪽 포인터가 알파벳일때
            if(Character.isAlphabetic(chars[leftPointer])) {
                //오른쪽 포인터도 알파벳이면 교환후, 포인터 둘다 이동
                if(Character.isAlphabetic(chars[rightPointer])) {
                    char temp = chars[leftPointer];
                    chars[leftPointer] = chars[rightPointer];
                    chars[rightPointer] = temp;
                    leftPointer++;
                    rightPointer--;
                } else { //오른쪽 포인터는 알파벳이 아니면 오른쪽 포인터만 왼쪽으로
                    rightPointer--;
                }
            } else {//왼쪽포인터가 알파벳이 아닐때
                //오른쪽 포인터는 알파벳이면 왼쪽 포인터만 오른쪽으로
                if(Character.isAlphabetic(chars[rightPointer])){
                    leftPointer++;
                } else{ //오른쪽 포인터도 알파벳이 아니면 포인터 둘다 이동
                    leftPointer++;
                    rightPointer--;
                }
            }
        }
        answer = String.valueOf(chars);
        return answer;
    }
}
