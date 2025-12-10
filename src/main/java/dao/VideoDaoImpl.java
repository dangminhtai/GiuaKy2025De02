package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import configs.DBContext;
import models.Video;

public class VideoDaoImpl implements IVideoDao {

    public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;

    @Override
    public Video findById(String videoId) {
        String sql = "SELECT * FROM Videos WHERE VideoId = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, videoId);
            rs = ps.executeQuery();
            if (rs.next()) {
                Video v = new Video();
                v.setVideoId(rs.getString("VideoId"));
                v.setTitle(rs.getString("Title"));
                v.setPoster(rs.getString("Poster"));
                v.setViews(rs.getInt("Views"));
                v.setDescription(rs.getString("Description"));
                v.setActive(rs.getBoolean("Active"));
                v.setCategoryId(rs.getInt("CategoryId"));
                return v;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Video> findAll() {
        List<Video> list = new ArrayList<>();
        String sql = "SELECT * FROM Videos";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Video v = new Video();
                v.setVideoId(rs.getString("VideoId"));
                v.setTitle(rs.getString("Title"));
                v.setPoster(rs.getString("Poster"));
                v.setViews(rs.getInt("Views"));
                v.setDescription(rs.getString("Description"));
                v.setActive(rs.getBoolean("Active"));
                v.setCategoryId(rs.getInt("CategoryId"));
                list.add(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Video> findByCategoryId(int categoryId) {
        List<Video> list = new ArrayList<>();
        String sql = "SELECT * FROM Videos WHERE CategoryId = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, categoryId);
            rs = ps.executeQuery();
            while (rs.next()) {
                Video v = new Video();
                v.setVideoId(rs.getString("VideoId"));
                v.setTitle(rs.getString("Title"));
                v.setPoster(rs.getString("Poster"));
                v.setViews(rs.getInt("Views"));
                v.setDescription(rs.getString("Description"));
                v.setActive(rs.getBoolean("Active"));
                v.setCategoryId(rs.getInt("CategoryId"));
                list.add(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int countByCategoryId(int categoryId) {
        String sql = "SELECT count(*) FROM Videos WHERE CategoryId = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, categoryId);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
