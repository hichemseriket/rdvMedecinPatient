package hichem.lightecomv1.dao;

import hichem.lightecomv1.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
