package sjtu.webapplication.ebook.dao;

import sjtu.webapplication.ebook.entity.Book;

import java.util.List;

public interface BookDao {
    Book findById(int id);
    List<Book> findAll();
    Book save(Book book);
    void delete(int id);
}
