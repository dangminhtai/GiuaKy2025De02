package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import configs.DBContext;
import models.Category;

public class CategoryDaoImpl implements ICategoryDao {

    public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;

    @Override
    public List<Category> findAll() {
        List<Category> list = new ArrayList<>();
        String sql = "SELECT * FROM Category";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Category c = new Category();
                c.setCategoryId(rs.getInt("CategoryId"));
                c.setCategoryname(rs.getString("Categoryname"));
                c.setCategorycode(rs.getString("Categorycode"));
                c.setImages(rs.getString("Images"));
                c.setStatus(rs.getBoolean("Status"));
                list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
