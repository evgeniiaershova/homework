public class Fibonacci {

    public static void main(String[] args) {

        long startTime1 = System.nanoTime();
        System.out.println(fibNonRec(20));

        long stopTime1 = System.nanoTime();
        long elapsedTime1 = stopTime1 - startTime1;
        System.out.println("Non rec: " + elapsedTime1);

        long startTime = System.nanoTime();
        System.out.println(fib(20));

        long stopTime = System.nanoTime();
        long elapsedTime = stopTime - startTime;
        System.out.println("Rec: " + elapsedTime);
    }

    public static long fib(long n) {
        if (n == 1) return 1;
        if (n == 2) return 1;
        return fib(n - 1) + fib(n - 2 );
    }

    public static long fibNonRec(long n) {
        long x1 = 1;
        long x2 = 1;
        long xn = 0;
        for (int i = 2; i < n; i++) {
            xn = x1 + x2;
            x1 = x2;
            x2 = xn;
        }
        return xn;
    }
}
