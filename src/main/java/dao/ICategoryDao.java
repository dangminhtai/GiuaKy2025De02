package dao;

import java.util.List;
import models.Category;

public interface ICategoryDao {
    List<Category> findAll();
}
