import java.util.Scanner;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {

        int[] capcities = w;
        int[] values = w;

        int VAL = values.length;
        int CAP = W;

        int[][] matrix = new int[VAL][CAP];
        for (int i = 0; i < VAL; i++) {

            int cap = capcities[i];
            for (int j = 0; j < CAP; j++) {

                if (cap == (j + 1)) {
                    matrix[i][j] = values[i];
                } else if (cap < (j + 1)) {
                    if (i > 0) {
                        matrix[i][j] = values[i] + matrix[i - 1][j - cap];
                    } else {
                        matrix[i][j] = values[i];
                    }
                }

                if (i > 0) {
                    matrix[i][j] = Math.max(matrix[i][j], matrix[i - 1][j]);
                }

            }
        }
        return matrix[VAL - 1][CAP - 1];

    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int W, n;
            W = scanner.nextInt();
            n = scanner.nextInt();
            int[] w = new int[n];
            for (int i = 0; i < n; i++) {
                w[i] = scanner.nextInt();
            }
            System.out.println(optimalWeight(W, w));
        }
    }
}
