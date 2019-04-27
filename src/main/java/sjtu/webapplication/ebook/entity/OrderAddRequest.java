package sjtu.webapplication.ebook.entity;

import java.util.List;

public class OrderAddRequest {
    private List<Integer> idList;
    private int userId;
    public OrderAddRequest(){}

    public List<Integer> getIdList() {
        return idList;
    }

    public int getUserid() {
        return userId;
    }

    public void setIdList(List<Integer> idList) {
        this.idList = idList;
    }

    public void setUserid(int userid) {
        this.userId = userid;
    }
}
