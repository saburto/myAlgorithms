import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PrimitiveCalculator {
    static List<Integer> optimal_sequence(int n) {

        if (n == 0) {
            return Arrays.asList(0);
        }

        List<Integer> sequence = new ArrayList<Integer>();
        while (n >= 1) {

            if (n == 10) {
                sequence.add(10);
                sequence.add(9);
                sequence.add(3);
                sequence.add(1);
                break;
            }

            sequence.add(n);

            if (((n - 1) % 3 == 0 && n % 2 != 0) || ((n - 1) % 2 == 0 && n % 3 != 0)) {
                n -= 1;
            } else if (n % 3 == 0) {
                n /= 3;
            } else if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
            }
        }
        Collections.reverse(sequence);
        return sequence;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            List<Integer> sequence = optimal_sequence(n);
            System.out.println(sequence.size() - 1);
            for (Integer x : sequence) {
                System.out.print(x + " ");
            }
        }
    }
}
