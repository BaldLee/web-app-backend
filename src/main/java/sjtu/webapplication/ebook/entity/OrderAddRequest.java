package sjtu.webapplication.ebook.entity;

import java.util.ArrayList;

public class OrderAddRequest {
    private ArrayList<Integer> cartId;
    private ArrayList<Integer> cartAmount;
    private String ownerName;

    public OrderAddRequest() {
    }


    public ArrayList<Integer> getCartId() {
        return cartId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public ArrayList<Integer> getCartAmount() {
        return cartAmount;
    }

    public void setCartId(ArrayList<Integer> idList) {
        this.cartId = idList;
    }

    public void setOwnerName(String name) {
        this.ownerName = name;
    }

    public void setCartAmount(ArrayList<Integer> cartAmount) {
        this.cartAmount = cartAmount;
    }
}
