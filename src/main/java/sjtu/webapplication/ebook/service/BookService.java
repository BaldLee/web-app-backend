package sjtu.webapplication.ebook.service;

import com.alibaba.fastjson.JSON;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.stereotype.Service;
import sjtu.webapplication.ebook.entity.Book;
import sjtu.webapplication.ebook.repository.BookRepository;


import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class BookService {

    @Resource
    private BookRepository bookRepository;

    public Iterable<Book> getAll() {
        return bookRepository.findAll();
    }

    public ArrayList<Book> getBookIfo() {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        StandardServiceRegistry registry = builder.configure().build();
        SessionFactory factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = null;
        ArrayList<Book> result = new ArrayList<Book>();

        try {
            transaction = session.beginTransaction();
            List books = session.createQuery("FROM books").list();
            for (Iterator iterator = books.iterator();
                 iterator.hasNext(); ) {
                Book book = (Book) iterator.next();
                result.add(book);
            }
            transaction.commit();
        } catch (HibernateException ex) {
            if (transaction != null) transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }

        return result;
    }

    public String get() {
        ArrayList<Book> result = this.getBookIfo();
        String output = JSON.toJSONString(result);
        return output;
    }
}
