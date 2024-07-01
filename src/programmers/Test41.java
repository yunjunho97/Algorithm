package programmers;

import java.util.ArrayList;

public class Test41 {
    static int[] check = new int[3];
    static ArrayList<char[]> op = new ArrayList<>();
    public static void main(String[] args) {
        String expression = "100-200*300-500+20";
        System.out.println(solution(expression));
    }

    public static long solution(String expression){
        ArrayList<Long> numberList = new ArrayList<>();
        ArrayList<Character> operatorList = new ArrayList<>();

        String temp = "";
        char[] arr = expression.toCharArray();
        for(int i = 0; i < arr.length; i++){
            if(Character.isDigit(arr[i])){
                temp += arr[i];
            } else {
                numberList.add(Long.parseLong(temp));
                operatorList.add(arr[i]);
                temp = "";
            }
        }
        numberList.add(Long.parseLong(temp));

        char[] operatorArr = {'+', '-', '*'};
        char[] t = new char[3];
        recursive(operatorArr, t, 0);

        long answer = 0;
        for(int i = 0; i < 6; i++){
            ArrayList<Long> a = new ArrayList<>(numberList);
            ArrayList<Character> b = new ArrayList<>(operatorList);
            long sum = Math.abs(calculate(a, b, i));
            answer = Math.max(answer, sum);
        }

        return answer;
    }

    public static long calculate(ArrayList<Long> numberList, ArrayList<Character> operatorList, int l){
        char[] opArr = op.get(l);
        for(int i = 0; i < 3; i++){
            if(opArr[i] == '+') {
                for(int j = 0; j < operatorList.size(); j++){
                    if(operatorList.get(j) == '+'){
                        operatorList.remove(j);
                        long num1 = numberList.get(j);
                        long num2 = numberList.get(j+1);
                        numberList.add(j, num1 + num2);
                        numberList.remove(j+1);
                        numberList.remove(j+1);
                        j--;
                    }
                }
            }
            else if(opArr[i] == '-') {
                for(int j = 0; j < operatorList.size(); j++){
                    if(operatorList.get(j) == '-'){
                        operatorList.remove(j);
                        long num1 = numberList.get(j);
                        long num2 = numberList.get(j+1);
                        numberList.add(j, num1 - num2);
                        numberList.remove(j+1);
                        numberList.remove(j+1);
                        j--;
                    }
                }
            }
            else if(opArr[i] == '*') {
                for(int j = 0; j < operatorList.size(); j++){
                    if(operatorList.get(j) == '*'){
                        operatorList.remove(j);
                        long num1 = numberList.get(j);
                        long num2 = numberList.get(j+1);
                        numberList.add(j, num1 * num2);
                        numberList.remove(j+1);
                        numberList.remove(j+1);
                        j--;
                    }
                }
            }
        }
        return numberList.get(0);
    }

    public static void recursive(char[] operatorArr, char[] arr, int l){
        if(l == 3){
            op.add(arr.clone());
            return;
        }
        for(int i = 0; i < 3; i++){
            if(check[i] == 0){
                check[i] = 1;
                arr[l] = operatorArr[i];
                recursive(operatorArr, arr, l+1);
                check[i] = 0;
            }
        }
    }
}
