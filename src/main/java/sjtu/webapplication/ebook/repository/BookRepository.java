package sjtu.webapplication.ebook.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sjtu.webapplication.ebook.entity.Book;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
//    @Query("select * from books u where u.status = 0")
//    List<Book> findAllExistBook();
    List<Book> findById(int id);
}
