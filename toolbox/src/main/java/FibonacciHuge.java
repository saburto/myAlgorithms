import java.util.Arrays;
import java.util.Scanner;

public class FibonacciHuge {

	static long getFibHuge(long n, long m) {
		long[] pisanoPeriod = getPisanoPeriod(m);
		long reminder = n % pisanoPeriod.length;
		return pisanoPeriod[(int) reminder];
	}

	static long[] getPisanoPeriod(long m) {
		if (m == 1) {
			return new long[] { 0 };
		}

		if (m == 2) {
			return new long[] { 0, 1, 1 };
		}

		return calc_fib(1000000, m);
	}

	static long[] calc_fib(final int n, long m) {
		long[] fib = new long[n + 4];
		fib[0] = 0;
		fib[1] = 1;
		for (int i = 2; i <= n; i++) {
			fib[i] = (fib[i - 1] + fib[i - 2]) % m;
			if (i > 3 && fib[i - 1] == 0 && fib[i] == 1) {
				return Arrays.copyOf(fib, i - 1);
			}
		}
		return new long[1];
	}

	static long getFibonacciHugeNaive(long n, long m) {
		if (n <= 1)
			return n;

		long previous = 0;
		long current = 1;

		for (long i = 0; i < n - 1; ++i) {
			long tmp_previous = previous;
			previous = current;
			current = tmp_previous + current;
		}

		return current % m;
	}

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong();
			long m = scanner.nextLong();
			System.out.println(getFibHuge(n, m));
		}
	}
}
