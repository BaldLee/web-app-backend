package sjtu.webapplication.ebook.serviceimpl;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sjtu.webapplication.ebook.dao.BookDao;
import sjtu.webapplication.ebook.entity.Book;
import sjtu.webapplication.ebook.repository.BookRepository;
import sjtu.webapplication.ebook.service.BookService;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    public String getAll() {
        return JSON.toJSONString(bookDao.findAll());
    }

    @Override
    @Transactional
    public String updateBook(Book book) {
        return JSON.toJSONString(bookDao.save(book));
    }

    @Override
    @Transactional
    public void deleteBook(int id) {
        bookDao.delete(id);
//        book.setStatus(1);
//        bookRepository.save(book);
    }

    @Override
    @Transactional
    public String findByID(int id) {
        return JSON.toJSONString(bookDao.findById(id));
    }
}
