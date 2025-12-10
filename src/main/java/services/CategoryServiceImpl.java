package services;

import java.util.List;
import dao.CategoryDaoImpl;
import dao.ICategoryDao;
import models.Category;

public class CategoryServiceImpl implements ICategoryService {

    ICategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }
}
