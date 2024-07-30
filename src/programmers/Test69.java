package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Test69 {
    public static void main(String[] args) {
        String[] cities = {"Jeju1","Jeju2","Jeju2","Jeju4"};
        System.out.println(solution(0, cities));
    }

    public static int solution(int cacheSize, String[] cities){
        int answer = 0;
        for(int i = 0; i < cities.length; i++){
            cities[i] = cities[i].toLowerCase();
        }
        Queue<String> queue = new LinkedList<>();
        for(String city : cities){
            if(queue.contains(city)){
                queue.remove(city);
                queue.add(city);
                answer += 1;
            } else {
                if(queue.size() == cacheSize && cacheSize != 0){
                    queue.poll();
                    queue.add(city);
                } else if(cacheSize != 0){
                    queue.add(city);
                }
                answer += 5;
            }
        }
        return answer;
    }
}
