import java.util.*;

public class LCM {
	static long lcm(long a, long b) {
		return a * b / gcd(a, b);
	}

	public static void main(String args[]) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			System.out.println(lcm(a, b));
		}
	}

	static long gcd(long a, long b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}
}
