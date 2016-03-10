import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private final ExecutorService threadPool;
    private boolean isStarted = false;

    private Main() {
        this.threadPool = Executors.newFixedThreadPool(10);
    }


    public static void main(String[] args) {
        new Main().start();
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
