package sjtu.webapplication.ebook.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sjtu.webapplication.ebook.dao.UserDao;
import sjtu.webapplication.ebook.entity.User;
import sjtu.webapplication.ebook.repository.UserRepository;
import sjtu.webapplication.ebook.service.UserService;

import javax.websocket.OnClose;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }
}
