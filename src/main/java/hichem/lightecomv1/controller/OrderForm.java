package hichem.lightecomv1.controller;

import hichem.lightecomv1.entity.Client;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class OrderForm {
    private Client client=new Client();
    private List<OrderProduct> products=new ArrayList<>();
//    @Autowired
//    public OrderForm(Client client, List<OrderProduct> products) {
//        this.client = client;
//        this.products = products;
//    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderProduct> getProducts() {
        return products;
    }

    public void setProducts(List<OrderProduct> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "OrderForm{" +
                "client=" + client +
                ", products=" + products +
                '}';
    }
}
