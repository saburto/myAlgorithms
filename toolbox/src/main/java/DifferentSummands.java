import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class DifferentSummands {
    static List<Integer> optimalSummands(final int n) {
        Set<Integer> summands = new HashSet<>();

        if (n <= 2) {
            summands.add(n);
        } else {

            int sub = 1;
            int remain = n;

            while (true) {
                remain = remain - sub;
                if (!summands.contains(remain) && remain > 0 && (remain - (sub + 1) >= 0)) {
                    summands.add(sub);
                    sub++;
                } else {
                    summands.add(remain + sub);
                    break;
                }
            }
        }
        return summands.stream()
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            List<Integer> summands = optimalSummands(n);
            System.out.println(summands.size());
            for (Integer summand : summands) {
                System.out.print(summand + " ");
            }
        }
    }
}
