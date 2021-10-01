package hichem.lightecomv1.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Ordere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrder;
//    private String nom;
//    private String email;
//    @ManyToMany(mappedBy = "Order")
//    @JsonIgnore
//    private List<Client> clients;
//    private Date date;
    private String date;
    @OneToMany(mappedBy = "ordere")
    private Collection<OrderItem> orderItems;
    @ManyToOne
    private Client client;
//    private double totalAmount;
    @OneToOne
    private Payment payment;

    public Ordere() {
    }

    public Ordere(Long idOrder, String date, Collection<OrderItem> orderItems, Client client, double totalAmount, Payment payment) {
        this.idOrder = idOrder;
        this.date = date;
        this.orderItems = orderItems;
        this.client = client;
//        this.totalAmount = totalAmount;
        this.payment = payment;
    }

    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Collection<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Collection<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

//    public double getTotalAmount() {
//        return totalAmount;
//    }
//
//    public void setTotalAmount(double totalAmount) {
//        this.totalAmount = totalAmount;
//    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idOrder=" + idOrder +
                ", date=" + date +
                ", orderItems=" + orderItems +
                ", client=" + client +
//                ", totalAmount=" + totalAmount +
                ", payment=" + payment +
                '}';
    }
}
