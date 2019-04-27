package sjtu.webapplication.ebook.entity;

import javax.persistence.*;

@Entity
@Table(name = "orderitem")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int order_id;
    private int item;
    private double price;

    public OrderItem() {
    }

    public int getId() {
        return id;
    }

    public int getItem() {
        return item;
    }

    public int getOrder_id() {
        return order_id;
    }

    public double getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
