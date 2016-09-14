import java.util.Scanner;

public class EditDistance {
    public static int editDistance(String s, String t) {

        int[][] matrix = new int[t.length() + 1][s.length() + 1];

        for (int i = 0; i <= t.length(); i++) {
            matrix[i][0] = i;
        }

        for (int i = 0; i <= s.length(); i++) {
            matrix[0][i] = i;
        }

        for (int j = 1; j <= s.length(); j++) {
            for (int i = 1; i <= t.length(); i++) {

                int insert = matrix[i][j - 1] + 1;
                int deletion = matrix[i - 1][j] + 1;
                int match = matrix[i - 1][j - 1];
                int mismatch = matrix[i - 1][j - 1] + 1;

                if (s.charAt(j - 1) == t.charAt(i - 1)) {
                    matrix[i][j] = Math.min(Math.min(insert, deletion), match);
                }else{
                    matrix[i][j] = Math.min(Math.min(insert, deletion), mismatch);
                }

            }
        }

        // for (int i = 0; i <= t.length(); i++) {
        // System.out.println(Arrays.toString(matrix[i]));
        // }

        // write your code here
        return matrix[t.length()][s.length()];
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        String s = scan.next();
        String t = scan.next();

        System.out.println(editDistance(s, t));
    }

}