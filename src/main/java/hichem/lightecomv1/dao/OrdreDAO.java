package hichem.lightecomv1.dao;

import hichem.lightecomv1.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Service

@Repository
public interface OrdreDAO extends JpaRepository<Order, Integer> {
    Order findByIdOrdre(int idOrdre);
}
