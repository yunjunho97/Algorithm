package programmers;

public class Test65 {
    public static void main(String[] args) {
        System.out.println(solution(16,16,2,1));
    }

    public static String solution(int n, int t, int m, int p){
        int length = 0;
        int i = 0;
        StringBuilder list = new StringBuilder();
        while(length < t * m) {
            String temp = Integer.toString(i, n);
            length += temp.length();
            list.append(temp);
            i++;
        }
        char[] clist = list.toString().toCharArray();
        StringBuilder answer = new StringBuilder();
        i = p-1;
        while(t > 0) {
            answer.append(clist[i]);
            i += m;
            t--;
        }
        return answer.toString().toUpperCase();
    }
}
