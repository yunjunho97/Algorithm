package programmers;

import java.util.Arrays;

public class Test66 {
    public static void main(String[] args) {
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        System.out.println(Arrays.toString(solution(files)));
    }

    public static String[] solution(String[] files){
        Arrays.sort(files, (o1, o2) -> {
            String[] o1Info = findHeader(o1);
            String[] o2Info = findHeader(o2);
            if(o1Info[0].equalsIgnoreCase(o2Info[0])) {
                return Integer.compare(Integer.parseInt(o1Info[1]), Integer.parseInt(o2Info[1]));
            }
            return o1Info[0].compareToIgnoreCase(o2Info[0]);
        });
        return files;
    }

    public static String[] findHeader(String name){
        char[] arr = name.toCharArray();
        StringBuilder header = new StringBuilder();
        StringBuilder number = new StringBuilder();
        int i = 0;
        while(!Character.isDigit(arr[i])){
            header.append(arr[i++]);
        }
        while(i < arr.length && Character.isDigit(arr[i])){
            number.append(arr[i++]);
        }
        return new String[]{header.toString(), number.toString()};
    }
}
