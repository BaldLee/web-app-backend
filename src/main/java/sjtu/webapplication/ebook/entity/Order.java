package sjtu.webapplication.ebook.entity;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Timestamp time;
    private int owner;
    private int status;

    public Order() {
    }

    public int getId() {
        return id;
    }

    public Timestamp getTime() {
        return time;
    }

    public int getOwner() {
        return owner;
    }

    public int getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
