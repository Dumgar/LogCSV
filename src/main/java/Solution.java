import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Solution {

    private final ExecutorService threadPool;
    private boolean isStarted = false;

    private Solution() {
        this.threadPool = Executors.newFixedThreadPool(10);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.start();
        solution.addNewFile("file1.csv");

    }

    public boolean isStarted() {
        return isStarted;
    }

    private void start() {
        isStarted = true;
    }

    private synchronized void stop() {
        isStarted = false;
        threadPool.shutdown();
        while (!threadPool.isTerminated()) {
        }
    }

    private void addNewFile(String fileName) {
        threadPool.execute(new Worker(fileName));
    }




}
