import java.util.Date;

/**
 * Created by romandmitriev on 10.03.16.
 */
public class LogLine {
    private Date date;
    private String userID;
    private String url;
    private int timeSpend;

    public LogLine(long date, String userID, String url, int timeSpend) {
        this.date.setTime(date);
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
