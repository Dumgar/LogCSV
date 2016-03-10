
public class Average {
    private int average;
    private int count = 1;

    public Average(LogLine elem) {
        average = elem.getTimeSpend();
    }

    public void add(int value) {
        average = (average * count + value) / (count + 1);
        count++;
    }

    public int getAverage() {return average;}
}
