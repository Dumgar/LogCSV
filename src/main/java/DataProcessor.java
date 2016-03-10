import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class DataProcessor {

    static ArrayList importData(String fileName) {
        ArrayList<LogLine> dataArray = new ArrayList<>();
        String currLine;
        int i = 0;

        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            br.readLine(); //TODO посмотреть как пропускать header
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

    static void exportData(String filename, HashMap<Date, HashMap<UnicID, Average>> hashMap) {

        SortedSet<Date> dataSet = new TreeSet<>(hashMap.keySet());

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {

            for (Date elem : dataSet) {

                bw.write(dateFormat.format(elem));
                bw.newLine();

                SortedSet<UnicID> unicIDSet = new TreeSet<>(hashMap.get(elem).keySet());

                for (UnicID unicIDElem : unicIDSet) {
                    bw.write(unicIDElem.getUserID() + "," + unicIDElem.getUrl() + "," + hashMap.get(elem).get(unicIDElem).getAverage());
                }
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    static HashMap<Date, HashMap<UnicID, Average>> dataAnalize(ArrayList<LogLine> arrayList, HashMap<Date, HashMap<UnicID, Average>> hashMap) {

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
        return hashMap;
    }

}
