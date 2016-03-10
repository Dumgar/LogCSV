
public final class UnicID implements Comparable{
    private final String userID;
    private final String url;

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

    @Override
    public int compareTo(Object o) {
        UnicID unicID = (UnicID) o;

        return userID.compareTo(unicID.getUserID());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UnicID unicID = (UnicID) o;

        if (userID != null ? !userID.equals(unicID.userID) : unicID.userID != null) return false;
        return url != null ? url.equals(unicID.url) : unicID.url == null;

    }

    @Override
    public int hashCode() {
        int result = userID != null ? userID.hashCode() : 0;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }
}
