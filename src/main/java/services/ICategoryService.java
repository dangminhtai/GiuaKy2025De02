package services;

import java.util.List;
import models.Category;

public interface ICategoryService {
    List<Category> findAll();
}
