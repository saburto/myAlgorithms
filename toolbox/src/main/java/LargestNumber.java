import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class LargestNumber {
    static String largestNumber(String[] a) {
        Arrays.sort(a, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                int compare = Character.compare(o2.charAt(0), o1.charAt(0));
                return compare == 0 ? secondCompare(o1, o2, 1, 0, 0) : compare;
            }

            private int secondCompare(String o1, String o2, int index, int oldIndex1, int oldIndex2) {
                if (index == Math.max(o1.length(), o2.length())) {
                    return 0;
                }
                int index1 = o1.length() > index ? index : oldIndex1;
                int index2 = o2.length() > index ? index : oldIndex2;
                int compare = Character.compare(o2.charAt(index2), o1.charAt(index1));
                return compare == 0 ? secondCompare(o1, o2, index + 1, index1, index2) : compare;
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
