package sjtu.webapplication.ebook.dao;

import org.springframework.stereotype.Repository;
import sjtu.webapplication.ebook.entity.User;

import java.util.List;

@Repository
public interface UserDao {
    List<User> findByUsername(String Username);
    List<User> findAll();
    User save(User user);
    void delete(User user);
}
