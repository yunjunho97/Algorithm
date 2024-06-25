package programmers;

public class Test31 {
    static boolean flag = false;
    static int answer = 0;
    public static void main(String[] args) {
        String word = "AAAAE";
        System.out.println(solution(word));
    }

    public static int solution(String word){
        String[] arr = {"A", "E", "I", "O", "U"};
        recursive2(word, "", arr);
        return answer;
    }

    public static void recursive(String word, String temp, String[] arr){
        if(flag) return;
        if(word.equals(temp)) {
            flag = true;
            return;
        }
        if(temp.length() == 5) return;

        for(int i = 0; i < 5; i++){
            answer++;
            recursive(word, temp+arr[i], arr);
            if(flag) break;
        }
    }

    public static boolean recursive2(String word, String temp, String[] arr){
        if(word.equals(temp)) return true;
        if(temp.length() == 5) return false;
        for(int i = 0; i < 5; i++){
            answer++;
            if(recursive2(word, temp+arr[i], arr)) return true;
        }
        return false;
    }
}
