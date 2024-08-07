package programmers;

public class Test79 {
    public static void main(String[] args) {
        String s = "3people unFollowed me";
        System.out.println(solution(s));
    }

    public static String solution(String s){
        char[] arr = s.toCharArray();
        boolean isFirst = true;

        for(int i = 0; i < arr.length; i++){
            if(isFirst) {
                arr[i] = Character.toUpperCase(arr[i]);
                isFirst = false;
            } else {
                arr[i] = Character.toLowerCase(arr[i]);
            }
            if(arr[i] == ' ') isFirst = true;
        }
        String result = new String(arr);
        return result;
    }
}
