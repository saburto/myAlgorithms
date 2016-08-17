import java.util.Scanner;

public class GCD {

	static int gcdOld(int a, int b) {
		int current_gcd = 1;
		for (int d = 2; d <= a && d <= b; ++d) {
			if (a % d == 0 && b % d == 0) {
				if (d > current_gcd) {
					current_gcd = d;
				}
			}
		}
		return current_gcd;
	}

	static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}

	public static void main(String args[]) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();

			System.out.println(gcd(a, b));
		}
	}

}
