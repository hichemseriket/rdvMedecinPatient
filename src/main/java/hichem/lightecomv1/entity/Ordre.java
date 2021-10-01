package hichem.lightecomv1.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Ordre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrdre;
    private Date date;
    @ManyToOne
    private Client client;
    private double totalAmount;


    public Ordre() {
    }

    public Ordre(Long idOrdre, Date date, Client client, double totalAmount) {
        this.idOrdre = idOrdre;
        this.date = date;
        this.client = client;
        this.totalAmount = totalAmount;
    }

    public Long getIdOrdre() {
        return idOrdre;
    }

    public void setIdOrdre(Long idOrdre) {
        this.idOrdre = idOrdre;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Ordre{" +
                "idOrdre=" + idOrdre +
                ", date=" + date +
                ", client=" + client +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
