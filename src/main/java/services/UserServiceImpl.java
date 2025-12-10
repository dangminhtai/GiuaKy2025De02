package services;

import dao.IUserDao;
import dao.UserDaoImpl;
import java.util.List;
import models.User;

public class UserServiceImpl implements IUserService {

    IUserDao userDao = new UserDaoImpl();

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public User login(String username, String password) {
        User user = this.findByUsername(username);
        if (user != null && password.equals(user.getPassword())) {
            return user;
        }
        return null;
    }

    @Override
    public void insert(User user) {
        userDao.insert(user);
    }

    @Override
    public boolean register(String username, String password, String email, String fullname, String phone) {
        if (userDao.findByUsername(username) != null) {
            return false;
        }
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setEmail(email);
        newUser.setFullname(fullname);
        newUser.setPhone(phone);
        newUser.setAdmin(false);
        newUser.setActive(true);
        userDao.insert(newUser);
        return true;
    }

    @Override
    public List<User> findAll(int page, int pageSize) {
        return userDao.findAll(page, pageSize);
    }

    @Override
    public int count() {
        return userDao.count();
    }

    @Override
    public void delete(String username) {
        userDao.delete(username);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }
}
