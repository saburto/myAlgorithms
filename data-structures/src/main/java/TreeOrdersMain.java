import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TreeOrdersMain {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public class TreeOrders {
        int n;
        int[] key, left, right;

        void read() throws IOException {
            FastScanner in = new FastScanner();
            n = in.nextInt();
            key = new int[n];
            left = new int[n];
            right = new int[n];
            for (int i = 0; i < n; i++) {
                key[i] = in.nextInt();
                left[i] = in.nextInt();
                right[i] = in.nextInt();
            }
        }

        List<Integer> inOrder() {
            ArrayList<Integer> result = new ArrayList<Integer>();
            // Finish the implementation
            // You may need to add a new recursive method to do that
            inOrder(0, result);

            return result;
        }

        private void inOrder(int i, ArrayList<Integer> result) {
            if (i >= n || i < 0) {
                return;
            }

            inOrder(left[i], result);
            result.add(key[i]);
            inOrder(right[i], result);
        }

        private void preOrder(int i, ArrayList<Integer> result) {
            if (i >= n || i < 0) {
                return;
            }

            result.add(key[i]);
            preOrder(left[i], result);
            preOrder(right[i], result);
        }

        private void postOrder(int i, ArrayList<Integer> result) {
            if (i >= n || i < 0) {
                return;
            }

            postOrder(left[i], result);
            postOrder(right[i], result);
            result.add(key[i]);
        }

        List<Integer> preOrder() {
            ArrayList<Integer> result = new ArrayList<Integer>();
            preOrder(0, result);
            return result;
        }

        List<Integer> postOrder() {
            ArrayList<Integer> result = new ArrayList<Integer>();
            postOrder(0, result);
            return result;
        }
    }

    static public void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new TreeOrdersMain().run();
                } catch (IOException e) {
                }
            }
        }, "1", 1 << 26).start();
    }

    public void print(List<Integer> x) {
        for (Integer a : x) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public void run() throws IOException {
        TreeOrders tree = new TreeOrders();
        tree.read();
        print(tree.inOrder());
        print(tree.preOrder());
        print(tree.postOrder());
    }
}