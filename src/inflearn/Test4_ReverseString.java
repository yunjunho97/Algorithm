package inflearn;

import java.util.ArrayList;
import java.util.Scanner;

public class Test4_ReverseString {
    public static void main(String[] args) {
        Test4_ReverseString reverseString = new Test4_ReverseString();
        Scanner scanner = new Scanner(System.in);

        //단어가 몇개인지 입력
        int count = scanner.nextInt();

        //int값 입력후에 버퍼에 남아있는 개행문자를 소비
        scanner.nextLine();

        //단어들을 각각 배열에 입력
        String[] str = new String[count];
        for(int i = 0; i < count; i++){
            str[i] = scanner.nextLine();
        }

        System.out.println(solution(count, str));

        /////////////////////////
        //solution2
        for(String x : solution2(count, str)){
            System.out.println(x);
        }

        /////////////////////////
        //solution3
        for(String x : solution3(count, str)){
            System.out.println(x);
        }
    }

    public static String solution(int count, String str[]) {
        String[] answer = new String[count];
        String answer2 = "";

        for (int i = 0; i < count; i++) {
            String empty = "";

            //char값들을 제일 앞부터 stack처럼 새 문자열에 하나씩 추가
            for (char c : str[i].toCharArray()) {
                empty = c + empty;
            }

            answer[i] = empty;
        }

        //출력을 위해 하나의 문자열로 합침
        for (int i = 0; i < count; i++) {
            answer2 += answer[i] + '\n';
        }

        return answer2;
    }

    //StringBuilder 사용
    public static ArrayList<String> solution2(int n, String[] str) {
        ArrayList<String> answer = new ArrayList<>();

        for(String x: str){
            //String은 String끼리 더하거나 replace같은걸 하면 새로운 객체가 생성된다
            //StringBuilder은 객체를 여러개 만들지 않고 그대로 사용
            String tmp = new StringBuilder(x).reverse().toString();
            answer.add(tmp);
        }

        return answer;
    }

    //제일 앞과 끝에 포인터를 각각 두고 포인터를 증감시키며 교체하는 방식
    public static ArrayList<String> solution3(int n, String[] str) {
        ArrayList<String> answer = new ArrayList<>();

        for(String x : str){
            char[] tmp = x.toCharArray();

            //pointer 초기화
            int leftPointer = 0;
            int rightPointer = tmp.length - 1;

            while(leftPointer < rightPointer) {
                //두 pointer가 가리키고 있는 값을 서로 교환
                char temp = tmp[leftPointer];
                tmp[leftPointer] = tmp[rightPointer];
                tmp[rightPointer] = temp;

                //pointer 증가, 감소
                leftPointer++;
                rightPointer--;
            }

            //char배열을 String값으로 변환
            String temp2 = String.valueOf(tmp);

            answer.add(temp2);
        }

        return answer;
    }
}
