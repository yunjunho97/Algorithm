package programmers;

import java.util.*;

public class Test5 {
    public static void main(String[] args) {
        String[][] book_time = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
        String[][] b = {{"00:01", "00:10"}, {"00:19", "00:29"}};
        String[][] c = {{"08:00", "08:30"}, {"08:00", "13:00"}, {"12:30", "13:30"}};
        String[][] d = {{"16:00", "16:10"}, {"16:20", "16:30"}, {"16:40", "16:50"}};
        String[][] e = {{"10:00", "10:10"}};
        System.out.println(solution(e));
    }

    public static int solution(String[][] book_time){
        ArrayList<Integer[]> book = new ArrayList<>();

        //시간을 분으로 환산해서 저장
        for(int i = 0; i < book_time.length; i++){
            int s1 = Integer.parseInt(book_time[i][0].split(":")[0]) * 60;
            int s2 = Integer.parseInt(book_time[i][0].split(":")[1]);
            int e1 = Integer.parseInt(book_time[i][1].split(":")[0]) * 60;
            int e2 = Integer.parseInt(book_time[i][1].split(":")[1]);
            int start = s1 + s2;
            int end = e1 + e2 + 10;
            book.add(i, new Integer[]{start, end});
        }

        //끝나는 시간을 기준으로 내림차순 정렬
        Collections.sort(book, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                if(o1[1] == o2[1]){
                    return Integer.compare(o2[0], o1[0]);
                }
                return Integer.compare(o2[1], o1[1]);
            }
        });

        //key: 방 번호, value: 시작시간과 끝나는 시간
        HashMap<Integer, Integer[]> room = new HashMap<>();
        int count = 0;
        room.put(count, book.get(0));
        for(int i = 1; i < book.size(); i++){
            int j = 0;
            while(j < room.size()){
                if(book.get(i)[1] <= room.get(j)[0]){
                    room.put(j, new Integer[]{book.get(i)[0], room.get(j)[1]});
                    break;
                } else {
                    j++;
                }
            }
            if(j == room.size()){
                count++;
                room.put(count, book.get(i));
            }
        }
        return room.size();
    }
}
