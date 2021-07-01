package problems;

public class Atoi {

    public static int myAtoi(String str) {
        str = str.trim();
        StringBuilder returnString = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            try {
                if (str.charAt(i) == '-' && str.length() > 1 && i == 0) {
                    int integer = Integer.parseInt(str.substring(i + 1, i + 2));
                    String number = str.charAt(i) + Integer.toString(integer);
                    returnString.append(number);
                    i = i + 1;
                }
                else if (str.charAt(i) == '+' && str.length() > 1 && i == 0) {
                    int integer = Integer.parseInt(str.substring(i + 1, i + 2));
                    String number = str.charAt(i) + Integer.toString(integer);
                    returnString.append(number);
                    i = i + 1;
                } else {
                    returnString.append(Integer.parseInt(str.substring(i, i + 1)));
                }
            } catch (NumberFormatException e) {
                break;
            }
        }

        if (returnString.toString().length() == 0) {
            return 0;
        }

        try {
            return Integer.parseInt(returnString.toString());
        } catch (NumberFormatException e) {
            if (returnString.toString().charAt(0) == '-') {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("   -42"));
    }
}
