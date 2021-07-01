package problems;

public class CoinChangeII {
    public static int change(int amount, int[] coins) {
        int[] combinations = new int[amount + 1];
        combinations[0] = 1;

        for (int coin : coins) {
            for (int i = 0; i <= amount; i++) {
                if (i >= coin) {
                    combinations[i] += combinations[i - coin];
                }
            }
        }
        return combinations[amount];
    }

    public static void main(String[] args) {

        /*
                    AMOUNT YOU ARE MAKING CHANGE FOR

                    0   1   2   3   4   5

             []     1   0   0   0   0   0

            [1]     1   1   1   1   1   1

          [1,2]     1   1   2   2   3   3

        [1,2,5]     1   1   2   2   3   4


         [1,2,3,4,5] k=2


         */

        /*
    public static int memoize(int amount, int[] coins) {
        if (amount == 0) {
            return 1;
        }

        if (amount < 0) {
            return 0;
        }

        int count = 0;

        for (int coin : coins) {
            amount -= coin;
            count += memoize(amount, coins);
        }

        return count;
    }
 */

        /*
        Input: amount = 5, coins = [1, 2, 5]
        Output: 4
        Explanation: there are four ways to make up the amount:
        5=5
        5=2+2+1
        5=2+1+1+1
        5=1+1+1+1+1
         */

        int amount = 5;
        int[] coins = {1, 2, 5};
        System.out.println(change(amount, coins));
    }
}
