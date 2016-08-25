import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class LargestNumber {
    static String largestNumber(String[] a) {
        Arrays.sort(a, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                String a = o1 + o2;
                String b = o2 + o1;
                return b.compareTo(a);
            }


        });
        String result = "";
        for (int i = 0; i < a.length; i++) {
            result += a[i];
        }
        return result;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            String[] a = new String[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.next();
            }
            System.out.println(largestNumber(a));
        }
    }
}
