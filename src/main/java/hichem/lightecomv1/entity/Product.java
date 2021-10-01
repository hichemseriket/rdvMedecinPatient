package hichem.lightecomv1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduct;
    private String nom;
    private String specialite;
    private String email;
    @ManyToMany(mappedBy = "product")
    @JsonIgnore
    private List<Client> clients;
    @ManyToOne
    private  Category category;

    public Product() {
    }

    public Product(Integer idProduct, String nom, String specialite, String email, List<Client> clients) {
        this.idProduct = idProduct;
        this.nom = nom;
        this.specialite = specialite;
        this.email = email;
        this.clients = clients;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Client> getRendezvous() {
        return clients;
    }

    public void setRendezvous(List<Client> rendezVous) {
        this.clients = rendezVous;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + idProduct +
                ", nom='" + nom + '\'' +
                ", specialite='" + specialite + '\'' +
                ", email='" + email + '\'' +
                ", rendezVous=" + clients +
                '}';
    }
}