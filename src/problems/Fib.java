package problems;

public class Fib {
    int total = 0;

    //next number is sum of previous two number
    int fib(int n) {
        if (n <= 1) {
//            total += n;
            return n;
        } else {
            int first = fib(n - 1);
            int second = fib(n - 2);
//            total += first + second;
//            System.out.println(total);
            return first + second;
        }
    }

    public static void main(String[] args) {
        Fib fib = new Fib();
        System.out.print(fib.fib(4));
    }
}
