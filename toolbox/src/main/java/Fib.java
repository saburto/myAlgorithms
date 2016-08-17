import java.util.Scanner;

public class Fib {

	public static long calc_fib(final int n) {
		if (n <= 1) {
			return n;
		}
		long[] fib = new long[n + 4];
		fib[0] = 0;
		fib[1] = 1;
		for (int i = 2; i <= n; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}
		return fib[n];
	}

	public static long calc_fibOLD(int n) {
		if (n <= 1)
			return n;

		return calc_fibOLD(n - 1) + calc_fibOLD(n - 2);
	}

	public static void main(String args[]) {
		try (Scanner in = new Scanner(System.in)) {
			int n = in.nextInt();
			System.out.println(calc_fib(n));
		}
	}
}
