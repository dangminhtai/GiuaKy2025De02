package dao;

import java.util.List;
import models.User;

public interface IUserDao {
    List<User> findAll();

    User findById(int id);

    User findByUsername(String username);

    void insert(User user);

    void update(User user);

    void delete(int id);

    boolean checkLogin(String username, String password);
}
