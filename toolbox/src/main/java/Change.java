import java.util.Scanner;

public class Change {

	final static int[] COINS = new int[] { 10, 5, 1 };

	static int getChange(final int m) {
		int count = 0;
		int value = m;
		int indexCoins = 0;

		while (value > 0) {
			if (value >= COINS[indexCoins]) {
				value -= COINS[indexCoins];
				count++;
			} else {
				indexCoins++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int m = scanner.nextInt();
			System.out.println(getChange(m));
		}

	}
}
