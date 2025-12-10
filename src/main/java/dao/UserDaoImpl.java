package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import configs.DBContext;
import models.User;

public class UserDaoImpl implements IUserDao {

    public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;

    @Override
    public List<User> findAll() {
        return findAll(1, 1000); // Default implementation
    }

    @Override
    public List<User> findAll(int page, int pageSize) {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users ORDER BY username LIMIT ? OFFSET ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, pageSize);
            ps.setInt(2, (page - 1) * pageSize);
            rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setFullname(rs.getString("fullname"));
                user.setPhone(rs.getString("phone"));
                user.setImages(rs.getString("images"));
                user.setAdmin(rs.getBoolean("admin"));
                user.setActive(rs.getBoolean("active"));
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User findById(int id) {
        // Not implemented because User uses String username as ID
        return null;
    }

    @Override
    public User findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ? ";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setFullname(rs.getString("fullname"));
                user.setPassword(rs.getString("password"));
                user.setImages(rs.getString("images"));
                user.setPhone(rs.getString("phone"));
                user.setAdmin(rs.getBoolean("admin"));
                user.setActive(rs.getBoolean("active"));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void insert(User user) {
        String sql = "INSERT INTO users(username, password, email, fullname, phone, images, admin, active) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getFullname());
            ps.setString(5, user.getPhone());
            ps.setString(6, user.getImages());
            ps.setBoolean(7, user.isAdmin());
            ps.setBoolean(8, user.isActive());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE users SET password = ?, email = ?, fullname = ?, phone = ?, images = ?, admin = ?, active = ? WHERE username = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getPassword());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getFullname());
            ps.setString(4, user.getPhone());
            ps.setString(5, user.getImages());
            ps.setBoolean(6, user.isAdmin());
            ps.setBoolean(7, user.isActive());
            ps.setString(8, user.getUsername());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String username) {
        String sql = "DELETE FROM users WHERE username = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int count() {
        String sql = "SELECT count(*) FROM users";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean checkLogin(String username, String password) {
        User user = findByUsername(username);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
