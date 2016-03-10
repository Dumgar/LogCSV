
public class UnicID {
    private String userID;
    private String url;

    public UnicID(LogLine elem) {
        this.userID = elem.getUserID();
        this.url = elem.getUrl();
    }

    public String getUserID() {
        return userID;
    }

    public String getUrl() {
        return url;
    }
}
