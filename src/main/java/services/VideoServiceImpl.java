package services;

import java.util.List;
import dao.IVideoDao;
import dao.VideoDaoImpl;
import models.Video;

public class VideoServiceImpl implements IVideoService {

    IVideoDao videoDao = new VideoDaoImpl();

    @Override
    public Video findById(String videoId) {
        return videoDao.findById(videoId);
    }

    @Override
    public List<Video> findAll() {
        return videoDao.findAll();
    }

    @Override
    public List<Video> findByCategoryId(int categoryId) {
        return videoDao.findByCategoryId(categoryId);
    }

    @Override
    public int countByCategoryId(int categoryId) {
        return videoDao.countByCategoryId(categoryId);
    }
}
