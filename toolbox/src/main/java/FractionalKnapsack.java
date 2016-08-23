import java.util.Arrays;
import java.util.Scanner;

public class FractionalKnapsack {

	static String getOptimalValue(final int capacity, ValueWight[] valueWights) {
		double value = 0;
		int capacityCounter = capacity;
		int indexValues = 0;

		Arrays.sort(valueWights);

		while (capacityCounter > 0 && indexValues < valueWights.length) {
			ValueWight valueWight = valueWights[indexValues];
			double qty = Math.min(valueWight.weights, capacityCounter);
			capacityCounter -= qty;
			indexValues++;
			value += valueWight.getUnitValue() * qty;
			valueWight.weights -= qty;
		}

		return String.format("%.4f", value);
	}

	public static void main(String args[]) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int capacity = scanner.nextInt();

			ValueWight[] valueWights = new ValueWight[n];
			for (int i = 0; i < n; i++) {
				valueWights[i] = new ValueWight(scanner.nextInt(), scanner.nextInt());
			}
			System.out.println(getOptimalValue(capacity, valueWights));
		}
	}

	public static class ValueWight implements Comparable<ValueWight> {
		double value;
		double weights;

		public ValueWight(int value, int weights) {
			this.value = value;
			this.weights = weights;
		}

		public double getUnitValue() {
			return value / weights;
		}

		@Override
		public int compareTo(ValueWight o) {
			return Double.compare(o.getUnitValue(), getUnitValue());
		}

		@Override
		public String toString() {
			return "[value=" + value + ", weights=" + weights + ", unit= " + getUnitValue() + "]";
		}

	}
}