import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciLastDigit {

	public static BigInteger calc_fib(final int n) {
		if (n <= 1) {
			return BigInteger.valueOf(n);
		}
		BigInteger first = BigInteger.ZERO;
		BigInteger second = BigInteger.ONE;
		for (int i = 2; i <= n; i++) {
			BigInteger temp = second;
			second = first.add(second).mod(BigInteger.TEN);
			first = temp;
		}
		return second;
	}

	public static int getFibonacciLastDigit(int n) {
		return calc_fib(n).intValue();
	}

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int c = getFibonacciLastDigit(n);
			System.out.println(c);
		}
	}
}
