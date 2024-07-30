package programmers;

import java.util.ArrayList;
import java.util.Iterator;

public class Test70 {
    public static void main(String[] args) {
        int m = 4;
        int n = 5;
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        System.out.println(solution(m, n, board));
    }
    //m= l
    //n= w
    public static int solution(int m, int n, String[] board){
        int answer = 0;
        ArrayList<ArrayList<Character>> totalBoard = new ArrayList<>();
        for(int i = 0; i < n; i++){
            ArrayList<Character> temp = new ArrayList<>();
            totalBoard.add(temp);
            for(int j = m-1; j >= 0; j--){
                temp.add(board[j].charAt(i));
            }
        }
        int count = 0;
        boolean flag = false;
        while(!flag) {
            for (int l = 0; l < m - 1; l++) {
                for (int w = 0; w < n - 1; w++) {
                    if (l + 1 >= totalBoard.get(w).size() || l + 1 >= totalBoard.get(w + 1).size()) continue;
                    char a = Character.toLowerCase(totalBoard.get(w).get(l));
                    char b = Character.toLowerCase(totalBoard.get(w + 1).get(l));
                    char c = Character.toLowerCase(totalBoard.get(w).get(l + 1));
                    char d = Character.toLowerCase(totalBoard.get(w + 1).get(l + 1));
                    if (a == b && b == c && c == d) {
                        totalBoard.get(w).set(l, a);
                        totalBoard.get(w + 1).set(l, b);
                        totalBoard.get(w).set(l + 1, c);
                        totalBoard.get(w + 1).set(l + 1, d);
                    }
                }
            }
            flag = true;
            for (int i = 0; i < totalBoard.size(); i++) {
                Iterator<Character> iterator = totalBoard.get(i).iterator();
                while (iterator.hasNext()) {
                    if (Character.isLowerCase(iterator.next())) {
                        flag = false;
                        iterator.remove();
                        count++;
                    }
                }
            }
            answer += count;
            count = 0;
        }
        return answer;
    }
}
