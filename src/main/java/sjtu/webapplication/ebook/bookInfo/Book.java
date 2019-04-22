package sjtu.webapplication.ebook.bookInfo;

public class Book {
    protected int id;
    protected String name;
    protected String author;
    protected String imgsrc;
    protected String isbn;

    public Book(){}

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuther(String auther) {
        this.author = auther;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuther() {
        return author;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public String getIsbn() {
        return isbn;
    }
}
