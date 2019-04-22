package sjtu.webapplication.ebook.service;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sjtu.webapplication.ebook.entity.Book;
import sjtu.webapplication.ebook.repository.BookRepository;

import java.util.List;

@Service
@Transactional
public class BookService {

    @Autowired
    private BookRepository bookRepository;

//    public List<Book> getAll() {
//        List<Book> result = bookRepository.findAllExistBook();
//        return result;
//    }

    public String getAll(){
        return JSON.toJSONString(bookRepository.findAll());
    }

    @Transactional
    public String updateBook(Book book) {
        return JSON.toJSONString(bookRepository.save(book));
    }

    @Transactional
    public void deleteBook(Book book){
        bookRepository.delete(book);
//        book.setStatus(1);
//        bookRepository.save(book);
    }
}
