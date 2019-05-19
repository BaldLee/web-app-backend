package sjtu.webapplication.ebook.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sjtu.webapplication.ebook.dao.BookDao;
import sjtu.webapplication.ebook.entity.Book;
import sjtu.webapplication.ebook.repository.BookRepository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book findById(int id) {
        return bookRepository.getOne(id);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void delete(Book book){
        bookRepository.delete(book);
    }
}
