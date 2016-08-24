import java.util.Arrays;
import java.util.Scanner;

public class DotProduct {
    static long maxDotProduct(long[] a, long[] b) {

        long sum = 0;
        Arrays.sort(a);
        Arrays.sort(b);

        for (int i = 0; i < b.length; i++) {
            sum += a[i] * b[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            long[] b = new long[n];
            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextInt();
            }
            System.out.println(maxDotProduct(a, b));
        }
    }
}
