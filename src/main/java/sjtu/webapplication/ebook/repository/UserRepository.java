package sjtu.webapplication.ebook.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sjtu.webapplication.ebook.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    List<User> findByUsername(String Username);
}
