package sjtu.webapplication.ebook.service;

import sjtu.webapplication.ebook.entity.Book;

public interface BookService {
    String getAll();

    String updateBook(Book book);

    void deleteBook(int id);

    String findByID(int id);
}
