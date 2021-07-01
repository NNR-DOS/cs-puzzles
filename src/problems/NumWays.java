package problems;

public class NumWays {

    public static int numWays(int n) {

        if (n == 0 || n == 1) {
            return 1;
        } else {
            return numWays(n-1) + numWays(n -2);
        }
    }

    public static void main(String[] args) {
        System.out.println(numWays(4));
    }
}
