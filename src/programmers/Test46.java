package programmers;

import java.util.HashMap;

public class Test46 {
    //20
    public static void main(String[] args) {
        System.out.println(solution("LULLLLLLU"));
    }

    public static int solution(String dirs){
        HashMap<String, Integer> map = new HashMap<>();
        int l = 0;
        int w = 0;
        int dl = l;
        int dw = w;
        char[] arr = dirs.toCharArray();
        for(char c : arr){
            if(c == 'U') {
                dl = l + 1;
                dw = w;
            } else if(c == 'D') {
                dl = l - 1;
                dw = w;
            } else if(c == 'R') {
                dl = l;
                dw = w + 1;
            } else if(c == 'L') {
                dl = l;
                dw = w - 1;
            }
            if(Math.abs(dl) <= 5 && Math.abs(dw) <= 5){
                String key1 = Integer.toString(l) + w + dl + dw;
                String key2 = Integer.toString(dl) + dw + l + w;
                map.put(key1, 1);
                map.put(key2, 1);
                l = dl;
                w = dw;
            }
        }
        return map.size() / 2;
    }
}
