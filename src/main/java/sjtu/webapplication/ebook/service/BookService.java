package sjtu.webapplication.ebook.service;

import org.springframework.stereotype.Service;
import sjtu.webapplication.ebook.entity.Book;
import sjtu.webapplication.ebook.repository.BookRepository;

import javax.annotation.Resource;

@Service
public class BookService {

    @Resource
    private BookRepository bookRepository;

    public Iterable<Book> getAll() {
        return bookRepository.findAll();
    }

}
