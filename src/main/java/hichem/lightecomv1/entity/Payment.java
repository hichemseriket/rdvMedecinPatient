package hichem.lightecomv1.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

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
    private Ordere ordere;

    public Payment() {
    }

    public Payment(Long id, String datePayment, long cardNumber, String cardType, Ordere ordere) {
        this.id = id;
        this.datePayment = datePayment;
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.ordere = ordere;
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

    public Ordere getOrder() {
        return ordere;
    }

    public void setOrder(Ordere ordere) {
        this.ordere = ordere;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", datePayment='" + datePayment + '\'' +
                ", cardNumber=" + cardNumber +
                ", cardType='" + cardType + '\'' +
                ", order=" + ordere +
                '}';
    }
}
