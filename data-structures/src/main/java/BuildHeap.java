import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BuildHeap {

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new BuildHeap().solve();
    }

    private int[] readData() throws IOException {
        int n = in.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; ++i) {
            data[i] = in.nextInt();
        }
        return data;
    }

    private void writeResponse(List<Swap> swaps) {
        out.println(swaps.size());
        for (Swap swap : swaps) {
            out.println(swap.index1 + " " + swap.index2);
        }
    }

    List<Swap> generateSwapsEfective(int[] data) {
        List<Swap> swaps = new ArrayList<Swap>();

        int size = data.length;

        for (int i = size / 2; i >= 0; i--) {
            siftDown(data, i, swaps);
        }

        return swaps;
    }

    private void siftDown(int[] data, int i, List<Swap> swaps) {
        int size = data.length;
        int maxIndex = i;
        int l = leftChild(i);

        if (l < size && data[l] < data[maxIndex]) {
            maxIndex = l;
        }

        int r = rightChild(i);

        if (r < size && data[r] < data[maxIndex]) {
            maxIndex = r;
        }

        if (i != maxIndex) {
            swap(data, i, maxIndex);
            swaps.add(new Swap(i, maxIndex));
            siftDown(data, maxIndex, swaps);
        }

    }

    private void swap(int[] data, int i, int maxIndex) {
        int tmp = data[i];
        data[i] = data[maxIndex];
        data[maxIndex] = tmp;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int[] data = readData();
        List<Swap> swaps = generateSwapsEfective(data);
        writeResponse(swaps);
        out.close();
    }

    public static class Swap {
        int index1;
        int index2;

        public Swap(int index1, int index2) {
            this.index1 = index1;
            this.index2 = index2;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + index1;
            result = prime * result + index2;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Swap other = (Swap) obj;
            if (index1 != other.index1)
                return false;
            if (index2 != other.index2)
                return false;
            return true;
        }

    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}