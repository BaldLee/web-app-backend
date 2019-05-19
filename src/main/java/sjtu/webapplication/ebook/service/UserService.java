package sjtu.webapplication.ebook.service;

import sjtu.webapplication.ebook.entity.User;

public interface UserService {
    String getAll();

    int logincheck(String username, String password);

    String updateUser(User user);

    void deleteUser(User user);
}
