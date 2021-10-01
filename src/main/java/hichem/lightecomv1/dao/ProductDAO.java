package hichem.lightecomv1.dao;

import hichem.lightecomv1.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//product ancienemnt medecin
//@Service

@Repository
public interface ProductDAO extends JpaRepository<Product,Integer> {
    Product findByIdProduct(int idProduct);
}
