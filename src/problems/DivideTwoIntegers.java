package problems;

public class DivideTwoIntegers {

    public static int divide(int dividend, int divisor) {

        int result = 0;

        int dividendReference = dividend;

        int divisorReference = divisor;

        dividend = dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(dividend);

        divisor = divisor == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(divisor);

        while(dividend - divisor >= 0) {
            result++;
            dividend = dividend - divisor;
        }

        if (divisorReference == Integer.MAX_VALUE || divisorReference == Integer.MIN_VALUE && dividendReference != divisorReference) {
            return 0;
        }

        if (dividendReference == Integer.MIN_VALUE && divisorReference == 1) {
            return Integer.MIN_VALUE;
        }

        if (dividendReference == Integer.MIN_VALUE && divisorReference == -1) {
            return Integer.MAX_VALUE;
        }

        if (dividendReference == Integer.MAX_VALUE && divisorReference == 1) {
            return Integer.MAX_VALUE;
        }

         if (dividendReference == Integer.MIN_VALUE && divisorReference > 0) {
             return result - (result + result) - 1;
         }

        if ((dividendReference < 0 && divisorReference > 0) || (divisorReference < 0 && dividendReference > 0)) {
            return result - (result + result);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.print(divide(2147483647, 2147483647));
    }
}
