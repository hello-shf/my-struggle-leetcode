package offer;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/11/21 21:23
 * @Version V1.0
 **/
public class Solution17 {
    public static void print(int n){
        double num = Math.pow(10, n);
        int i = 1;
        while (i < num){
            System.out.println(i ++);
        }
    }
    public static void printToMaxOfDigits3(int n) {
        if(n < 0) {
            return;
        }

        char[] number = new char[n];
        for(int i = 0; i < number.length; i++) {
            number[i] = '0';
        }
        for(int i = 0; i <= 9; i++) {
            printToMaxOfDigitRecursively(n, number, i, 0);
        }
    }

    private static void printToMaxOfDigitRecursively(int n, char[] number, int nNumber, int index) {
        if(index == number.length - 1) {
            number[index] = (char)(nNumber + '0');
            printCharNumber(number);
            return;
        }else{
            number[index] = (char)(nNumber + '0');
            for(int i = 0; i <= 9; i++) {
                printToMaxOfDigitRecursively(n, number, i ,index+1);
            }
        }
    }

    public static void printCharNumber(char[] number) {
        boolean isBeginning0 = true;
        for(int i = 0; i < number.length; i++) {
            if(isBeginning0 && number[i] - '0' != 0) {
                isBeginning0 = false;
            }
            if(!isBeginning0) {
                System.out.print(number[i]);
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {
        /*System.out.println(Integer.MAX_VALUE);
        double a = Integer.MAX_VALUE + 1;
        System.out.println(a);
        System.out.println((int) (a - 2.00));

        BigDecimal b1 = new BigDecimal("10000000001");
        BigDecimal b2 = new BigDecimal("10000000002");
        String s = b1.add(b2).toString();
        Double v = b1.add(b2).doubleValue();
        System.out.println(s);
        System.out.println(v.toString());*/

    }
}

