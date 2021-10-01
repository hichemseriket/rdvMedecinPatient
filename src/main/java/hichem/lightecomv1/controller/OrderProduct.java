package hichem.lightecomv1.controller;

import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@Data
class OrderProduct {
    private Long id;
    private int quantity;
}
