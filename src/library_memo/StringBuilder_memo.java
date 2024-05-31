package library_memo;

public class StringBuilder_memo {

    public static void main(String[] args) {

        StringBuilder stringBuilder = new StringBuilder("0123456");

        //0. toString() StringBuilder의 내용을 String으로 변환하여 반환
        //StringBuilder 는 내부적으로 char[] 배열을 통해 문자열을 저장하고 관리한다
        //StringBuilder 객체가 생성될 때 배열이 초기 크기로 할당되고
        //기존 크기보다 더 많은 문자열이 추가되면 새로운 더 큰 배열이 할당되고 기존 배열의 내용은 새로운 배열로 복사된다
        //기존 크기보다 작아지는 경우에는 배열을 축소하는 작업을 하지는 않는다, 크기는 변경되지 않고 그대로 유지된다
        //내부 배열의 사용된 부분만 변경이 된다

        //내부 배열의 크기를 명시적으로 줄이려면 trimToSize()를 사용
        //현재 문자열의 길이에 맞게 내부 배열의 크기를 조정

        //1. 제일 끝에 추가
        String temp1 = stringBuilder.append("append").toString();
        System.out.println("append 결과");
        System.out.println(temp1);
        System.out.println();

        //2. 사이에 삽입
        String temp2 = new StringBuilder("0123456").insert(5, "V").toString();
        System.out.println("insert(5, \"V\") 결과");
        System.out.println(temp2);
        System.out.println();

        //3. 범위만큼 삭제
        String temp3 = new StringBuilder("0123456").delete(1, 4).toString();
        System.out.println("delete(1, 4) 결과");
        System.out.println(temp3);
        System.out.println();

        //4. 하나만 삭제
        String temp4 = new StringBuilder("0123456").deleteCharAt(1).toString();
        System.out.println("deleteCharAt(1) 결과");
        System.out.println(temp4);
        System.out.println();

        //5. 범위를 다른문자열로 대체
        String temp5 = new StringBuilder("0123456").replace(1, 4, "a").toString();
        System.out.println("replace(1, 4, \"a\") 결과");
        System.out.println(temp5);
        System.out.println();

        //6. 범위를 문자열로 반환
        String temp6 = new StringBuilder("0123456").substring(1, 4);
        System.out.println("substring(1, 4) 결과");
        System.out.println(temp6);
        System.out.println();

        //7. 문자열 뒤집기
        String temp7 = new StringBuilder("0123456").reverse().toString();
        System.out.println("reverse 결과");
        System.out.println(temp7);
        System.out.println();

        //8. 문자열 길이 반환
        int temp8 = new StringBuilder("0123456").length();
        System.out.println("length 결과");
        System.out.println(temp8);
        System.out.println();

        //9. 해당위치 char 값 반환
        char temp9 = new StringBuilder("0123456").charAt(1);
        System.out.println("charAt(1) 결과");
        System.out.println(temp9);
        System.out.println();

    }
}
