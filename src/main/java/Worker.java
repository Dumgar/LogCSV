
public class Worker implements Runnable {
    private final String fileName;
    private final DataProcessor dataProcessor;

    public Worker(String fileName) {
        this.fileName = fileName;
        dataProcessor = new DataProcessor();
    }

    public void run() {
        dataProcessor.importData(fileName);


    }
}
