import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Optional;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class HashChains {

    private FastScanner in;
    // store all strings in one list
    private LinkedList<String>[] elems;
    // for hash function
    private int bucketCount;
    private int prime = 1000000007;
    private int multiplier = 263;

    public static void main(String[] args) throws IOException {
        new HashChains().processQueries();
    }

    private int hashFunc(String s) {
        long hash = 0;
        for (int i = s.length() - 1; i >= 0; --i)
            hash = (hash * multiplier + s.charAt(i)) % prime;
        return (int) hash % bucketCount;
    }

    private Query readQuery() throws IOException {
        String type = in.next();
        if (!type.equals("check")) {
            String s = in.next();
            return new Query(type, s);
        } else {
            int ind = in.nextInt();
            return new Query(type, ind);
        }
    }

    private void writeSearchResult(boolean wasFound) {
        System.out.println(wasFound ? "yes" : "no");
        // Uncomment the following if you want to play with the program
        // interactively.
        // out.flush();
    }

    void processQuery(Query query) {
        int index = query.s == null ? query.ind : hashFunc(query.s);
        switch (query.type) {
        case "add":
            getElement(index).ifPresent((e) -> {
                if (!e.contains(query.s)) {
                    e.addFirst(query.s);
                }
            });
            break;
        case "del":
            getElement(index).ifPresent((e) -> {
                e.remove(query.s);
            });
            break;
        case "find":
            getElement(index).ifPresent((e) -> {
                writeSearchResult(e.contains(query.s));
            });
            break;
        case "check":
            getElement(index).ifPresent((e) -> {
                String collect = e.stream()
                        .collect(Collectors.joining(" "));
                System.out.println(collect);
            });

            // Uncomment the following if you want to play with the program
            // interactively.
            // out.flush();
            break;
        default:
            throw new RuntimeException("Unknown query: " + query.type);
        }
    }

    Optional<LinkedList<String>> getElement(int index) {
        if (index < 0 || index > bucketCount) {
            return Optional.empty();
        }

        if (elems[index] == null) {
            elems[index] = new LinkedList<>();
        }

        return Optional.ofNullable(elems[index]);
    }

    public void processQueries() throws IOException {
        in = new FastScanner();
        setNewBucket(in.nextInt());
        int queryCount = in.nextInt();
        for (int i = 0; i < queryCount; ++i) {
            processQuery(readQuery());
        }
    }

    void setNewBucket(int size) {
        bucketCount = size;
        elems = new LinkedList[size];
    }

    static class Query {
        String type;
        String s;
        int ind;

        public Query(String type, String s) {
            this.type = type;
            this.s = s;
        }

        public Query(String type, int ind) {
            this.type = type;
            this.ind = ind;
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