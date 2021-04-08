public class Fibonnaci {
    private static long startTime = System.currentTimeMillis();
    public static int fibr(int n) {

        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;

        return fibr(n - 1) + fibr(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fibr(60));
        long timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("программа выполнялась " + timeSpent + " миллисекунд");
    }
    }
