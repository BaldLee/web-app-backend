package sjtu.webapplication.ebook.entity;

import java.sql.Timestamp;

public class OrderStatisticRequest {
    private Timestamp start;
    private Timestamp end;
    private String username;

    public OrderStatisticRequest() {
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    public void setEnd(Timestamp end) {
        this.end = end;
    }

    public Timestamp getEnd() {
        return end;
    }

    public Timestamp getStart() {
        return start;
    }

    public String getUsername() {
        return username;
    }
}
