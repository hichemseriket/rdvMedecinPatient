package hichem.lightecomv1.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = true)
    private Integer idClient;
    private String dateClient;

    @ManyToMany
    private List<Product> product;

    @ManyToMany
    private List<Ordre> ordre;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="CATEGORY_ID_CATEGORY", nullable=true)
    private List<Category> category;

    public Client() {
    }

    public Client(Integer idClient, String dateClient, List<Product> product, List<Ordre> ordre, List<Category> category) {
        this.idClient = idClient;
        this.dateClient = dateClient;
        this.product = product;
        this.ordre = ordre;
        this.category = category;
    }

    //    public Client(Integer idClient, String dateClient, Product product, List<Patient> patient, List<Category> category) {
//        this.idClient = idClient;
//        this.dateClient = dateClient;
//        this.product = product;
//        this.patient = patient;
//        this.category = category;
//    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getDateClient() {
        return dateClient;
    }

    public void setDateClient(String dateClient) {
        this.dateClient = dateClient;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }
    //
//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }

    public List<Ordre> getPatient() {
        return ordre;
    }

    public void setPatient(List<Ordre> ordre) {
        this.ordre = ordre;
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", dateClient='" + dateClient + '\'' +
                ", product=" + product +
                ", patient=" + ordre +
                ", category=" + category +
                '}';
    }
}
