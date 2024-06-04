package library_memo;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class IntStream_memo {
    public static void main(String[] args) {

        //IntStream 생성
        //1. 배열에서 생성 - 이것보다 4번이 나은거같음
        int[] numbers = {1, 2, 3, 4, 5};
        IntStream streamByArray = Arrays.stream(numbers);

        //2. 범위로 생성
        IntStream streamByRange1 = IntStream.range(1, 6); //1, 2, 3, 4, 5
        IntStream streamByRange2 = IntStream.rangeClosed(1, 5); //1, 2, 3, 4, 5

        //3. 빌더 사용
        IntStream streamByBuilder = IntStream.builder().add(1).add(2).build();

        //4.
        IntStream streamOf = IntStream.of(numbers);
        System.out.println(streamOf.sum());

        //5. iterate
        int[] array3 = IntStream.iterate(9, i -> i - 1).limit(9).toArray();
        System.out.println(Arrays.toString(array3));// 9 ~ 1

        //중간연산
        //1. filter 조건에 맞는것만 남김
        IntStream.of(numbers).filter(o -> o % 2 == 0).forEach(o -> System.out.print(o + " "));
        System.out.println(); //2, 4

        //2. map 각 요소를 반환
        IntStream.of(numbers).map(o -> o * 2).forEach(o -> System.out.print(o + " "));
        System.out.println(); //2, 4, 6, 8, 10

        //3. distinct 중복 제거
        IntStream.of(numbers).distinct().forEach(o -> System.out.print(o + " "));
        System.out.println(); //1, 2, 3, 4, 5

        //4. sorted 정렬
        IntStream.of(numbers).sorted().forEach(o -> System.out.print(o + " "));
        System.out.println(); //1, 2, 3, 4, 5

        //5. takeWhile 언제 까지만 실행
        IntStream.rangeClosed(1, 10).takeWhile(i -> i < 5).forEach(o -> System.out.print(o + " "));
        System.out.println();//1, 2, 3, 4

        //6. dropWhile 언제 까지는 버리고 이후로 실행
        IntStream.rangeClosed(1, 10).dropWhile(i -> i < 5).forEach(o -> System.out.print(o + " "));
        System.out.println();//5, 6, 7, 8, 9, 10

        //최종연산
        //1. forEach 각 요소에 대한 작업

        //2. toArray 스트림을 배열로 반환
        int[] array = IntStream.of(numbers).toArray();
        System.out.println(Arrays.toString(array));

        //3. sum 모든 요소의 합
        int sum = IntStream.of(numbers).sum();
        System.out.println(sum);

        //4. count 요소의 개수
        long count = IntStream.of(numbers).count(); //long으로 반환됨
        System.out.println(count);

        //5. average 평균
        OptionalDouble average = IntStream.of(numbers).average(); //OptionalDouble로 반환
        System.out.println(average);
        double v = IntStream.of(numbers).average().orElse(0.0);
        System.out.println(v);

        //6. max, min 최대 최소값
        OptionalInt max = IntStream.of(numbers).max(); //OptionalInt로 반환
        OptionalInt min = IntStream.of(numbers).min(); //OptionalInt로 반환
        System.out.println(max);
        System.out.println(min);
        int maxI = IntStream.of(numbers).max().orElse(0); //int로 반환
        int minI = IntStream.of(numbers).min().getAsInt(); //int로 반환
        System.out.println(maxI);
        System.out.println(minI);

        //집계 연산
        //reduce(초기값, 연산)
        OptionalInt reduce = IntStream.of(numbers).reduce((a, b) -> a + b);
        System.out.println(reduce);
        int reduce1 = IntStream.of(numbers).reduce(10, (a, b) -> a - b);
        System.out.println(reduce1);

        //연습코드
        System.out.println("=============연습코드=================");

        //평균값
        int[] arr1 = {5, 2, 9, 1, 7, 4, 6, 3, 8};
        double meanTest = IntStream.of(arr1).average().orElse(0.0);
        System.out.println(meanTest);

        //양수, 음수
        int[] arr2 = {4, -2, 9, -7, 5, 1, -3, 6, -1, 8};
        int[] array1 = IntStream.of(arr2).filter(i -> i > 0).toArray();
        int[] array2 = IntStream.of(arr2).filter(i -> i < 0).toArray();
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));

        //피보나치 수열 - Arrays.setAll
        int[] fibo = new int[30];
        Arrays.setAll(fibo, i -> i < 2 ? 1 : fibo[i-1] + fibo[i-2]);
        System.out.println(Arrays.toString(fibo));

        //IntStream 2중
        IntStream.rangeClosed(1, 9)
                .forEach(i -> IntStream.rangeClosed(1, 9)
                        .forEach(j -> System.out.println(i + " x " + j + " = " + i*j)));

        //IntStream 2중
        IntStream.rangeClosed(1, 9)
                .forEach(i -> IntStream.rangeClosed(1, 9)
                        .forEach(j -> {
                            System.out.println(i + " x " + j + " = " + i*j);
                        }));

        //IntStream 내림차순
        IntStream.iterate(9, i -> i - 1)
                .limit(8)
                .forEach(i -> {
                    IntStream.iterate(9, j -> j - 1)
                            .limit(9)
                            .forEach(j -> System.out.print(i + " x " + j + " "));
                    System.out.println();
                });
    }
}
