import java.io.*;
import java.util.ArrayList;

public class DataProcessor {

    static ArrayList importData(File file) {
        ArrayList<LogLine> dataArray = new ArrayList<>();
        String currLine;
        int i = 0;

        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((currLine = br.readLine()) != null){
                String[] sArr = currLine.split(",");
                LogLine temp = new LogLine(Long.parseLong(sArr[0]), sArr[1], sArr[2], Integer.parseInt(sArr[3]));
                dataArray.add(i, temp);
                i++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataArray;
    }

    static void exportData() {

    }

    static void dataAnalize() {

    }
}
