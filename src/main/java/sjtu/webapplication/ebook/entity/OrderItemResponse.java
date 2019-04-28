package sjtu.webapplication.ebook.entity;

public class OrderItemResponse {
    private Book book;
    private int amount;

    public OrderItemResponse() {
    }


    public void setBook(Book book) {
        this.book = book;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Book getBook() {
        return book;
    }

    public int getAmount() {
        return amount;
    }
}
