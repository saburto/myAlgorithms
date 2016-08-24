import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciPartialSum {

	public static int getFibonacciPartialSum(long from, long to) {

		BigInteger first = BigInteger.ZERO;
		BigInteger second = BigInteger.ONE;
		int sum = from <= 1 ? second.intValue() : 0;
		for (int i = 2; i <= to; i++) {
			BigInteger temp = second;
			second = first.add(second).mod(BigInteger.TEN);
			first = temp;
			if (i >= from) {
				sum += second.intValue();
			}
		}
		return sum % 10;
	}

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long from = scanner.nextLong();
			long to = scanner.nextLong();
			System.out.println(getFibonacciPartialSum(from, to));
		}
	}
}
