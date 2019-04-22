package sjtu.webapplication.ebook.service;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import sjtu.webapplication.ebook.entity.User;
import sjtu.webapplication.ebook.repository.UserRepository;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String getAll() {
        return JSON.toJSONString(userRepository.findAll());
    }

    public int logincheck(String username, String password) {
        List<User> userList = userRepository.findByUsername(username);

        if (userList.isEmpty()) return -1;

        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getStatus() == 1) {
                if (!userList.get(i).getPassword().equals(md5Password)) continue;
                if (userList.get(i).getRole() == 0) return 0;
                else return 1;
            }
        }
        return -1;
    }

    @Transactional
    public String updateUser(User user) {
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        return JSON.toJSONString(userRepository.save(user));
    }

    @Transactional
    public void deleteUser(User user){
        userRepository.delete(user);
//        book.setStatus(1);
//        bookRepository.save(book);
    }

//    public List<User> findTest(String username) {
//        return userRepository.findByUsername(username);
//    }
}
