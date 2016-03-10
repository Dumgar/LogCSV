import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Worker implements Runnable {
    private final String fileName;
    private final DataProcessor dataProcessor;

    public Worker(String fileName) {
        this.fileName = fileName;
        dataProcessor = new DataProcessor();
    }

    public void run() {

        ArrayList<LogLine> arrayList = dataProcessor.importData(fileName);

        dataProcessor.exportData(fileName, dataProcessor.dataAnalize(arrayList));
    }
}
