import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class JobQueue {

    public static class JobThread {
        long startTime;
        public int workerId;
        public int duration;

        public boolean hasFreeTime() {
            // TODO Auto-generated method stub
            return false;
        }

        public long newStartTime() {
            // TODO Auto-generated method stub
            return 0;
        }

        public void tick() {
            // TODO Auto-generated method stub

        }
    }

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new JobQueue().solve();
    }

    private Queue<Integer> readJobs() throws IOException {
        int m = in.nextInt();
        Queue<Integer> jobs = new LinkedList<>();
        for (int i = 0; i < m; ++i) {
            jobs.add(in.nextInt());
        }
        return jobs;
    }

    private void writeResponse(List<Pair> result) {
        for (Pair pair : result) {
            out.println(pair.worker + " " + pair.startTime);
        }
    }

    public List<Pair> assignJobsNew(Queue<Integer> jobs, int numWorkers) {
        List<Pair> pairs = new LinkedList<>();

        PriorityQueue<JobThread> priorityQueue = new PriorityQueue<>((x, y) -> Long.compare(x.startTime, y.startTime));
        for (int i = 0; i < numWorkers; i++) {
            priorityQueue.add(new JobThread());
        }

        while (!jobs.isEmpty()) {
            int duration = jobs.poll();

            boolean check = true;
            while (check) {
                JobThread peek = priorityQueue.poll();
                if (peek.hasFreeTime()) {
                    peek.duration = duration;
                    pairs.add(new Pair(peek.workerId, peek.newStartTime()));
                } else {
                    peek.tick();
                }

                if (priorityQueue.isEmpty()) {
                    check = false;
                }
                priorityQueue.add(peek);
            }
        }
        return pairs;
    }

    public List<Pair> assignJobs(Queue<Integer> jobs, int numWorkers) {
        List<Pair> pairs = new LinkedList<>();
        long[] nextFreeTime = new long[numWorkers];
        while (!jobs.isEmpty()) {
            int duration = jobs.poll();
            int bestWorker = 0;
            for (int j = 0; j < numWorkers; ++j) {
                if (nextFreeTime[j] < nextFreeTime[bestWorker])
                    bestWorker = j;
            }
            pairs.add(new Pair(bestWorker, nextFreeTime[bestWorker]));
            nextFreeTime[bestWorker] += duration;
        }
        return pairs;
    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int numWorkers = in.nextInt();
        Queue<Integer> jobs = readJobs();
        List<Pair> result = assignJobs(jobs, numWorkers);
        writeResponse(result);
        out.close();
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

    public static class Pair {
        public Pair(int worker, long startTime) {
            this.worker = worker;
            this.startTime = startTime;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + (int) (startTime ^ (startTime >>> 32));
            result = prime * result + worker;
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
            Pair other = (Pair) obj;
            if (startTime != other.startTime)
                return false;
            if (worker != other.worker)
                return false;
            return true;
        }

        int worker;
        long startTime;
    }
}