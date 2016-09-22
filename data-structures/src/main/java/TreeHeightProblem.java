import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class TreeHeightProblem {
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

    class TreeHeight {
        int n;
        int parent[];
        Map<Integer, List<Integer>> map = new HashMap<>();

        void read() throws IOException {
            FastScanner in = new FastScanner();
            n = in.nextInt();
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = in.nextInt();
                map.putIfAbsent(parent[i], new ArrayList<>());
                map.get(parent[i])
                .add(i);
            }
        }

        int computeHeight() {


            List<Integer> list = map.getOrDefault(-1, new ArrayList<>());

            return computeHeight(list);
        }

        private int computeHeight(List<Integer> list) {
            if (list.isEmpty()) {
                return 0;
            }

            int max = 0;
            for (Integer integer : list) {
                max = Math.max(max, computeHeight(map.getOrDefault(integer, new ArrayList<>())));
            }
            return 1 + max;
        }
    }

    static public void main(String[] args) throws IOException, InterruptedException {
        Thread thread = new Thread(null, new Runnable() {
            public void run() {
                try {
                    new TreeHeightProblem().run();
                } catch (IOException e) {
                }
            }
        }, "1", 1 << 26);
        thread.start();
        thread.join();
    }

    public void run() throws IOException {
        TreeHeight tree = new TreeHeight();
        tree.read();
        System.out.println(tree.computeHeight());
    }
}