package sjtu.webapplication.ebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sjtu.webapplication.ebook.entity.Book;
import sjtu.webapplication.ebook.repository.BookRepository;

@Service
@Transactional
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Iterable<Book> getAll() {
        return bookRepository.findAll();
    }

}
