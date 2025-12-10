package dao;

import java.util.List;
import models.User;

public interface IUserDao {
    List<User> findAll(int page, int pageSize);

    List<User> findAll();

    User findById(int id);

    User findByUsername(String username);

    void insert(User user);

    void update(User user);

    void delete(String username);

    int count();

    boolean checkLogin(String username, String password);
}
