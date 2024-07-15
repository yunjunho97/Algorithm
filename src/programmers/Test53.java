package programmers;

public class Test53 {
    static int[] checked;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        String name = "JAN";
        System.out.println(solution3(name));
    }

    public static int solution3(String name){
        int answer = 0;
        int count = 0;
        char[] arr = name.toCharArray();
        int[] numbers = new int[arr.length];
        checked = new int[arr.length];
        for(int i = 0; i < numbers.length; i++){
            numbers[i] = solution2(arr[i]);
            answer += numbers[i];
            if(arr[i] != 'A') count++;
        }
        recursive(0, 0, count, numbers, arr.length);
        answer += min;
        return answer;
    }

    public static void recursive(int l, int sum, int count, int[] numbers, int size){
        if(numbers[l] != 0 && checked[l] == 0) {
            count--;
            checked[l] = 1;
        }

        if(count == 0) {
            min = Math.min(min, sum);
            return;
        }
        int tempL = l;
        int tempSum = sum;
        //정방향
        while(true){
            l++;
            sum++;
            if(l == size) l = 0;
            if(numbers[l] != 0 && checked[l] == 0) break;
        }
        recursive(l, sum, count, numbers, size);
        checked[l] = 0;

        l = tempL;
        sum = tempSum;
        //역방향
        while(true){
            l--;
            sum++;
            if(l == -1) l = size-1;
            if(numbers[l] != 0 && checked[l] == 0) break;
        }
        recursive(l, sum, count, numbers, size);
        checked[l] = 0;
    }

    public static int solution2(char c){
        return (c - 'A' < 'Z' - c + 1) ? c - 'A' : 'Z' - c + 1;
    }

    public static int solution(String name){
        int answer = 0;
        char[] arr = name.toCharArray();
        int pointer = 0;
        int left = 0;
        int right = arr.length - 1;

        while(left <= right) {
            while(left < arr.length && arr[left] == 'A') left++;
            while(right >= 0 && arr[right] == 'A') right--;

            int leftDistance = distance(arr.length, left, pointer);
            int rightDistance = distance(arr.length, right, pointer);

            if(leftDistance <= rightDistance){
                answer += leftDistance;
                pointer = left;
                left++;
            } else {
                answer += rightDistance;
                pointer = right;
                right--;
            }
            answer += solution2(arr[pointer]);
        }

        return answer;
    }

    public static int distance(int size, int target, int pointer){
        int distance1 = target - pointer;
        int distance2 = pointer - target;
        if(distance1 < 0) distance1 += size;
        if(distance2 < 0) distance2 += size;
        return Math.min(distance1, distance2);
    }
}
