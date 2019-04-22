package sjtu.webapplication.ebook.entity;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
    private int id;

    //    @Column(name = "name")
    private String name;

    //    @Column(name = "author")
    private String author;

    //    @Column(name = "imgsrc")
    private String imgsrc;

    //    @Column(name = "isbn",unique = true)
    private String isbn;

    //    @Column(name = "price")
    private double price;

    //    @Column(name = "amount")
    private int amount;

    //    @Column(name = "status")
    private int status;

    public Book() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public double getPrice() {
        return price;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getAmount() {
        return amount;
    }

    public int getStatus() {
        return status;
    }
}
