package hichem.lightecomv1.dao;

import hichem.lightecomv1.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Service

@Repository
public interface CategoryDAO extends JpaRepository<Category, Integer> {
    Category findByIdCategory(int idCategory);
}
