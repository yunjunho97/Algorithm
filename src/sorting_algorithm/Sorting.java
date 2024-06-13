package sorting_algorithm;

import java.util.*;

public class Sorting {

    public static void main(String[] args) {
        System.out.println("ArrayList 정렬");
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < 10; i++){
            list.add(random.nextInt(100));
        }
        Collections.sort(list);
        System.out.println(list);
        Collections.sort(list, ((o1, o2) -> o2 - o1));
        System.out.println(list);

        ArrayList<ArrayList<Integer>> list1 = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            ArrayList<Integer> list2 = new ArrayList<>();
            for(int j = 0; j < 3; j++){
                list2.add(random.nextInt(100));
            }
            list1.add(list2);
        }
        System.out.println(list1);

        Collections.sort(list1, (o1, o2) -> o1.get(0) - o2.get(0));
        System.out.println(list1);

        Collections.sort(list1.get(0), (o1, o2) -> o1 - o2);
        System.out.println(list1.get(0));

        System.out.println("---------------------------------------");
        System.out.println("arr 정렬");
        int[] arr = new int[10];
        for(int i = 0; i < 10; i++){
            arr[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int[][] arr1 = new int[10][3];
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 3; j++){
                arr1[i][j] = random.nextInt(100);
            }
        }
        for(int i = 0; i < 10; i++){
            System.out.print(Arrays.toString(arr1[i]) + ", ");
        }
        System.out.println();

        Arrays.sort(arr1, (o1, o2) -> o2[0] - o1[0]);
        for(int i = 0; i < 10; i++){
            System.out.print(Arrays.toString(arr1[i]) + ", ");
        }
        System.out.println();

        Arrays.sort(arr1, (o1, o2) -> o1[0] - o2[0]);
        for(int i = 0; i < 10; i++){
            System.out.print(Arrays.toString(arr1[i]) + ", ");
        }
        System.out.println();
        System.out.println("---------------------------------------");
        System.out.println("HashMap의 value를 기준으로 정렬 - keySet -> get");
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < 10; i++){
            map.put(i, random.nextInt(100));
        }
        System.out.println(map);

        ArrayList<Integer> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList, (o1, o2) -> map.get(o1) - map.get(o2));
        for(int key : keyList){
            System.out.print(key + "=" + map.get(key) + ", ");
        }
        System.out.println();

        Collections.sort(keyList, (o1, o2) -> map.get(o2) - map.get(o1));
        for(int key : keyList){
            System.out.print(key + "=" + map.get(key) + ", ");
        }
        System.out.println();

        System.out.println("---------------------------------------");
        System.out.println("HashMap의 value를 기준으로 정렬 - Map.Entry -> getValue");
        ArrayList<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        System.out.println(entryList);

        Collections.sort(entryList, (o1, o2) -> o1.getValue() - o2.getValue());
        System.out.println(entryList);

        Collections.sort(entryList, (o1, o2) -> o2.getValue() - o1.getValue());
        System.out.println(entryList);

    }
}
