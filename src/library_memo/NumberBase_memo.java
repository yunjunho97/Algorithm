package library_memo;

public class NumberBase_memo {
    public static void main(String[] args) {

        int decimal = 10;
        //n진수로 변환
        String temp = Integer.toString(decimal, 3);
        System.out.println(temp);

        //10진수 -> 2진수
        String binary = Integer.toBinaryString(decimal);
        System.out.println("binary = " + binary);

        //10진수 -> 8진수
        String octal = Integer.toOctalString(decimal);
        System.out.println("octal = " + octal);

        //10진수 -> 16진수
        String hex = Integer.toHexString(decimal);
        System.out.println("hex = " + hex);

        //2진수 -> 10진수
        String binary_ = "11";
        int decimalByBinary = Integer.parseInt(binary_, 2);
        System.out.println("decimalByBinary = " + decimalByBinary);

        //8진수 -> 10진수
        String octal_ = "11";
        int decimalByOctal = Integer.parseInt(octal_, 8);
        System.out.println("decimalByOctal = " + decimalByOctal);

        //16진수 -> 10진수
        String hex_ = "11";
        int decimalByHex = Integer.parseInt(hex_, 16);
        System.out.println("decimalByHex = " + decimalByHex);
    }
}
