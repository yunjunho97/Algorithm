package inflearn;

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
    }

    public static String solution(int count, String str[]) {
        String[] answer = new String[count];
        String answer2 = "";

        for (int i = 0; i < count; i++) {
            String empty = "";

            //char값들을 stack형식으로 새 문자열에 하나씩 추가
            for (char c : str[i].toCharArray()) {
                empty = c + empty;
            }

            answer[i] = empty;
        }

        for (int i = 0; i < count; i++) {
            answer2 += answer[i] + '\n';
        }

        return answer2;
    }
}
