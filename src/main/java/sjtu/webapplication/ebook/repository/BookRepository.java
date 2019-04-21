package sjtu.webapplication.ebook.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sjtu.webapplication.ebook.entity.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

}
