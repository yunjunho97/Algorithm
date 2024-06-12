package programmers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test13 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{14,35,119}, new int[]{18, 30, 102}));
    }

    //두 배열에 각각

    //첫번째 수의 모든 약수를 구해서 배열을 만든다
    //두번째 수 부터 해당 배열에 대한 유효성 검사를 통해 배열을 갱신한다

    //만들어진 두 배열을 비교

    public static int solution(int[] arrayA, int[] arrayB){
        int answer = 0;

        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();

        //필요시 정렬

        int numA = arrayA[0];
        int numB = arrayB[0];

        //배열에서 가장 작은수의 모든 약수를 구하기
        for(int i = 2; i <= numA/2; i++){
            if(numA % i == 0) listA.add(i);
        }
        listA.add(numA);

        for(int i = 2; i <= numB/2; i++){
            if(numB % i == 0) listB.add(i);
        }
        listB.add(numB);

        //유효성 검사: 위에서 얻은 약수들이 배열원소들의 약수인지 검사하고 아닌건 제거
        for(int i = 1; i < arrayA.length; i++){
            Iterator<Integer> iterator = listA.iterator();
            while(iterator.hasNext()){
                int a = iterator.next();
                if(arrayA[i] % a != 0) iterator.remove();
            }
            if(listA.isEmpty()) break;
        }
        for(int i = 1; i < arrayB.length; i++){
            Iterator<Integer> iterator = listB.iterator();
            while(iterator.hasNext()){
                int b = iterator.next();
                if(arrayB[i] % b != 0) iterator.remove();
            }
            if(listB.isEmpty()) break;
        }

        //두 약수배열(listA, listB) 비교
        int pointA = listA.size()-1;
        int pointB = listB.size()-1;
        //제일 오른쪽부터 같은 값 제거
        while(pointA >= 0 && pointB >= 0){
            if(listA.get(pointA) == listB.get(pointB)){
                pointA--;
                pointB--;
            } else {
                break;
            }
        }

        //약수배열이 둘다 0이면 답이 없는 경우
        if(pointA == -1 && pointB == -1){
            return 0;
        }

        //한쪽의 약수배열만 남았다면 그 약수배열에 대해서만 검사
        //b -> a
        if(pointA == -1){
            for(int i = listB.size()-1; i >= 0; i--){
                if(solution2(arrayA, listB.get(i)) != -1) return listB.get(i);
            }
            return 0;
        }
        //a -> b
        if(pointB == -1){
            for(int i = listA.size()-1; i >= 0; i--){
                if(solution2(arrayB, listA.get(i)) != -1) return listA.get(i);
            }
            return 0;
        }

        //양쪽 약수배열이 모두 남아있다면 큰 수부터 검사
        while(pointA >= 0 && pointB >= 0){
            if(listA.get(pointA) > listB.get(pointB)){
                if(solution2(arrayB, listA.get(pointA)) != -1){
                    return listA.get(pointA);
                } else {
                    pointA--;
                }
            } else {
                if(solution2(arrayA, listB.get(pointB)) != -1){
                    return listB.get(pointB);
                } else {
                    pointB--;
                }
            }
            if(pointA == -1) listA.add(-1);
            if(pointB == -1) listB.add(-1);
            if(listA.get(0) == -1 && listB.get(0) == -1) return 0;
        }

        return answer;
    }
    public static int solution2(int[] arr, int i) {
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] % i == 0) return -1;
        }
        return i;
    }
}
