package sjtu.webapplication.ebook.entity;

import java.util.ArrayList;

public class OrderAddRequest {
    private ArrayList<Integer> cartId;
    private String ownerName;

    public OrderAddRequest() {
    }


    public ArrayList<Integer> getCartId() {
        return cartId;
    }

    public String getOwnerName() {
        return ownerName;
    }


    public void setCartId(ArrayList<Integer> idList) {
        this.cartId = idList;
    }

    public void setOwnerName(String name) {
        this.ownerName = name;
    }
}
