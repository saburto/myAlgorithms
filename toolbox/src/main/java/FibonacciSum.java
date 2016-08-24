import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class FibonacciSum {

	public static BigInteger SUM_CYCLE;

	static{
		SUM_CYCLE = BigInteger.valueOf(Arrays.stream(getPisanoPeriodFor10()).sum());
	}

	public static int getFibonacciSum(final long n) {
		int sum = 0;
		int[] pisanoPeriod = getPisanoPeriodFor10();

		int i = 0;
		double l2 = n % pisanoPeriod.length;
		while (i <= l2) {
			sum += pisanoPeriod[(int) (i % pisanoPeriod.length)];
			i++;
		}

		long l = n / pisanoPeriod.length;
		return SUM_CYCLE.multiply(BigInteger.valueOf(l))
				.add(BigInteger.valueOf(sum))
				.mod(BigInteger.TEN)
				.intValue();

	}

	static int[] getPisanoPeriodFor10() {
		return new int[] { 0, 1, 1, 2, 3, 5, 8, 3, 1, 4, 5, 9, 4, 3, 7, 0, 7, 7, 4, 1, 5, 6, 1, 7, 8, 5, 3, 8, 1, 9, 0,
				9, 9, 8, 7, 5, 2, 7, 9, 6, 5, 1, 6, 7, 3, 0, 3, 3, 6, 9, 5, 4, 9, 3, 2, 5, 7, 2, 9, 1 };
	}

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong();
			int c = getFibonacciSum(n);
			System.out.println(c);
		}
	}
}
