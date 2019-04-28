package sjtu.webapplication.ebook.entity;

import javax.persistence.*;

@Entity
@Table(name = "orderitem")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int orderid;
    private int item;
    private double price;
    private int amount;

    public OrderItem() {
    }

    public int getId() {
        return id;
    }

    public int getItem() {
        return item;
    }

    public int getOrderid() {
        return orderid;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
