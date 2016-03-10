import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class DataProcessor {

    static ArrayList importData(String fileName) {
        ArrayList<LogLine> dataArray = new ArrayList<>();
        String currLine;
        int i = 0;

        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
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

    static void dataAnalize(ArrayList<LogLine> arrayList, HashMap<Date, HashMap<UnicID, Average>> hashMap) {

        for (int i = 0; i < arrayList.size(); i++) {
            LogLine elem = arrayList.get(i);

            UnicID unicID = new UnicID(elem);
            Average average = new Average(elem);

            if (hashMap.containsKey(elem.getDate())) {
                HashMap<UnicID, Average> temp = hashMap.get(elem.getDate());
                if (temp.containsKey(unicID)) {
                    Average value = temp.get(unicID);
                    value.add(elem.getTimeSpend());
                    temp.put(unicID, value);
                } else {
                    temp.put(unicID, average);
                }

                hashMap.put(elem.getDate(), temp);

            } else {
                HashMap<UnicID, Average> temp = new HashMap<>();
                temp.put(unicID, average);
                hashMap.put(elem.getDate(), temp);
            }
        }
    }
}
