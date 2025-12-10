package services;

import java.util.List;
import models.User;

public interface IUserService {
    User findByUsername(String username);

    User login(String username, String password);

    void insert(User user);

    boolean register(String username, String password, String email, String fullname, String phone);

    List<User> findAll(int page, int pageSize);

    int count();

    void delete(String username);

    void update(User user);
}
