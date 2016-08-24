import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class CoveringSegments {

    static Set<Integer> optimalPoints(Segment[] segments) {

        Arrays.sort(segments);

        Set<Integer> points = new TreeSet<>();

        int end = segments[0].end;
        for (int i = 1; i < segments.length; i++) {
            if (!segments[i].isInRange(end)) {
                points.add(end);
                end = segments[i].end;
                if (i == segments.length - 1) {
                    points.add(end);
                }
            } else if (i == segments.length - 1) {
                points.add(end);
            }
        }

        return points;
    }

    static class Segment implements Comparable<Segment> {
        int start;
        int end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean isInRange(int point) {
            return point >= start && point <= end;
        }

        @Override
        public int compareTo(Segment o) {
            return Integer.compare(end, o.end);
        }

        @Override
        public String toString() {
            return "Segment [start=" + start + ", end=" + end + "]";
        }

    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            Segment[] segments = new Segment[n];
            for (int i = 0; i < n; i++) {
                int start, end;
                start = scanner.nextInt();
                end = scanner.nextInt();
                segments[i] = new Segment(start, end);
            }
            Set<Integer> points = optimalPoints(segments);
            System.out.println(points.size());
            for (int point : points) {
                System.out.print(point + " ");
            }
        }
    }
}
