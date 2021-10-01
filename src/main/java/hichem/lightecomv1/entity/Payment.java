package hichem.lightecomv1.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Payment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    private Date datePayment;
    private String datePayment;
    private long cardNumber;
    private String cardType;
    @OneToOne(mappedBy = "payment")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private hichem.lightecomv1.entity.Order order;

    public Payment() {
    }

    public Payment(Long id, String datePayment, long cardNumber, String cardType, Order order) {
        this.id = id;
        this.datePayment = datePayment;
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDatePayment() {
        return datePayment;
    }

    public void setDatePayment(String datePayment) {
        this.datePayment = datePayment;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", datePayment='" + datePayment + '\'' +
                ", cardNumber=" + cardNumber +
                ", cardType='" + cardType + '\'' +
                ", order=" + order +
                '}';
    }
}
