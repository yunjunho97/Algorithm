package sorting_algorithm;

public class SelectionSort {
    public static void main(String[] args) {
        int n = 6;
        int[] list = {13, 5, 11, 7, 23, 15};
        solution(n, list);
    }

    //가장 앞부터 제일 작은 수가 쌓여가는 방식
    public static void solution(int n, int[] list){
        //n 배열의 길이
        //list 배열

        for(int i = 0; i < n; i++){ //i는 0부터
            int pointer = i;
            for(int j = i+1; j < n; j++){ //j는 i의 바로 다음부터
                //pointer를 가장 작은 값에 위치시킴
                if(list[j] < list[pointer]){
                    pointer = j;
                }
            }
            //pointer의 값과 i의 값을 swap
            int temp = list[i];
            list[i] = list[pointer];
            list[pointer] = temp;
        }

        //결과
        for(int i = 0; i < n; i++){
            System.out.print(list[i] + " ");
        }
    }
}
