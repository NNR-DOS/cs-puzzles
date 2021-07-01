package problems;

public class ReverseInteger {

    public static int reverse(int x) {
        int integer = x;
        if (integer < 0) {
            integer = Math.abs(integer);
            StringBuilder integerStringAbsoluteValue = new StringBuilder(String.valueOf(Integer.toString(integer).toCharArray()));
            try {
                int number = Integer.parseInt(integerStringAbsoluteValue.reverse().toString());
                return number - 2 * number;
            } catch (NumberFormatException e) {
                return 0;
            }
        }
        StringBuilder integerStringAbsoluteValue = new StringBuilder(String.valueOf(Integer.toString(integer).toCharArray()));
        try {
            return Integer.parseInt(integerStringAbsoluteValue.reverse().toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.print(reverse(-123));
    }
}
