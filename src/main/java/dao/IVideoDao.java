package dao;

import java.util.List;
import models.Video;

public interface IVideoDao {
    Video findById(String videoId);

    List<Video> findAll();

    List<Video> findByCategoryId(int categoryId);

    int countByCategoryId(int categoryId);
}
