package sjtu.webapplication.ebook.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sjtu.webapplication.ebook.entity.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

    @Query("select u from Book where u.id = :id")
    public Book findBookById(@Param("id") int id);

}
