import java.util.Date;

public class LogLine {
    private final Date date;
    private String userID;
    private String url;
    private int timeSpend;

    public LogLine(long date, String userID, String url, int timeSpend) {
        this.date = new Date(date);
        this.userID = userID;
        this.url = url;
        this.timeSpend = timeSpend;
    }

    public Date getDate() {
        return date;
    }

    public String getUserID() {
        return userID;
    }

    public String getUrl() {
        return url;
    }

    public int getTimeSpend() {
        return timeSpend;
    }
}
