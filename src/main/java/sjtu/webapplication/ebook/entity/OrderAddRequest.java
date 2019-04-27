package sjtu.webapplication.ebook.entity;

import java.util.List;

public class OrderAddRequest {
    private List<Integer> cartId;
    private String ownerName;
    public OrderAddRequest(){}

    public List<Integer> getCartId() {
        return cartId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setCartId(List<Integer> idList) {
        this.cartId = idList;
    }

    public void setOwnerName(String name) {
        this.ownerName = name;
    }
}
