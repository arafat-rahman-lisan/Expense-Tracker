package interfaces;

import entities.Category;

public interface ICategoryRepo {
    void insertCategory(Category c);
    void removeCategory(String id);
    void updateCategory(Category c);
    Category searchCategory(String id);
    Category[] getAllCategories();
}
