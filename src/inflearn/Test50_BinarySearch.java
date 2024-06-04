package inflearn;

public class Test50_BinarySearch {
    public static void main(String[] args) {
        int[] list = {12, 23, 32, 57, 65, 81, 87, 99};
        int k = 33;
        solution(list, k);
    }

    public static void solution(int[] list, int target){
        int answer = -1;
        int leftPointer = 0;
        int rightPointer = list.length-1;
        int midPointer = (leftPointer + rightPointer) / 2;

        while(leftPointer <= rightPointer){
            if(list[midPointer] < target){
                leftPointer = midPointer + 1;
            } else if(list[midPointer] > target){
                rightPointer = midPointer - 1;
            } else {
                answer = midPointer;
                break;
            }
            midPointer = (leftPointer + rightPointer) / 2;
        }
        System.out.println(answer);
    }
}
