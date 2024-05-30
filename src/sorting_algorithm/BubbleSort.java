package sorting_algorithm;

public class BubbleSort {
    public static void main(String[] args) {
        int n = 6;
        int[] list = {13, 5, 11, 7, 23, 15};
        solution(n, list);
    }

    //가장 뒤부터 가장 큰 수가 쌓여가는 방식
    public static void solution(int n, int[] list){
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < n-1-i; j++){
                if(list[j] > list[j+1]){
                    int temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                }
            }
        }
        for(int i : list){
            System.out.print(i + " ");
        }
    }
}
