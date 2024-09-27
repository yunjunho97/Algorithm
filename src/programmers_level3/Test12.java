package programmers_level3;

import java.util.ArrayList;
import java.util.Arrays;

public class Test12 {
    static int[] unf;
    public static void main(String[] args) {
        String[] commands = {"UPDATE 1 1 menu", "UPDATE 1 2 category", "UPDATE 2 1 bibimbap",
                "UPDATE 2 2 korean", "UPDATE 2 3 rice", "UPDATE 3 1 ramyeon",
                "UPDATE 3 2 korean", "UPDATE 3 3 noodle", "UPDATE 3 4 instant",
                "UPDATE 4 1 pasta", "UPDATE 4 2 italian", "UPDATE 4 3 noodle",
                "MERGE 1 2 1 3", "MERGE 1 3 1 4", "UPDATE korean hansik",
                "UPDATE 1 3 group",
                "UNMERGE 1 4",
                "PRINT 1 3", "PRINT 1 4"};
        String[] commands2 = {"UPDATE 1 1 a", "UPDATE 1 2 b",
                "UPDATE 2 1 c", "UPDATE 2 2 d",
                "MERGE 1 1 1 2", "MERGE 2 2 2 1", "MERGE 2 1 1 1",
                "PRINT 1 1",
                "UNMERGE 2 2",
                "PRINT 1 1"};
        String[] commands3 = {"MERGE 1 1 2 2",
                "UPDATE 1 1 A",
                "UNMERGE 1 1",
                "PRINT 1 1",

                "PRINT 2 2"};
        System.out.println(Arrays.toString(solution(commands2)));
    }

    public static String[] solution(String[] commands) {
        //초기화
        unf = new int[5051];
        String[] values = new String[5051];
        for(int i = 0; i < unf.length; i++) {
            unf[i] = i;
        }

        ArrayList<String> result = new ArrayList<>();

        for(String command : commands) {
            String[] arr = command.split(" ");
            String task = arr[0];

            if(task.equals("UPDATE")) {
                if(arr.length == 4) {
                    int location = find(Integer.parseInt(arr[1]) * 100 + Integer.parseInt(arr[2]));
                    values[location] = arr[3];
                } else {
                    for(int i = 0; i < values.length; i++) {
                        if(values[i] != null && values[i].equals(arr[1])) values[i] = arr[2];
                    }
                }
            } else if(task.equals("MERGE")) {
                int locationA = find(Integer.parseInt(arr[1]) * 100 + Integer.parseInt(arr[2]));
                int locationB = find(Integer.parseInt(arr[3]) * 100 + Integer.parseInt(arr[4]));
                if(locationA == locationB) continue;

                if(values[locationA] == null && values[locationB] == null) {
                    union(locationB, locationA);
                } else if(values[locationA] == null) {
                    union(locationA, locationB);
                } else if(values[locationB] == null) {
                    union(locationB, locationA);
                } else {
                    union(locationB, locationA);
                }
            } else if(task.equals("UNMERGE")) {
                int location = find(Integer.parseInt(arr[1]) * 100 + Integer.parseInt(arr[2]));
                String value = values[location];
                ArrayList<Integer> temp = new ArrayList<>();
                for(int i = 0; i < unf.length; i++) {
                    if(find(i) == location) {
                        temp.add(i);
                    }
                }
                for(int key : temp) {
                    unf[key] = key;
                    values[key] = null;
                }
                values[Integer.parseInt(arr[1]) * 100 + Integer.parseInt(arr[2])] = value;
            } else if(task.equals("PRINT")) {
                String value = values[find(Integer.parseInt(arr[1]) * 100 + Integer.parseInt(arr[2]))];
                if(value == null) result.add("EMPTY");
                else result.add(value);
            }
        }
        String[] answer = new String[result.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    public static int find(int v) {
        if(v == unf[v]) return v;
        else return unf[v] = find(unf[v]);
    }

    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if(fa != fb) unf[fa] = fb;
    }
}
