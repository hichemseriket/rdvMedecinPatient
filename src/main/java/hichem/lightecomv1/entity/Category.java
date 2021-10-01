package hichem.lightecomv1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategory;
    private String dateCategory;
    private String rapportCategory;
    private Double prixCategory;
    @ManyToMany(cascade=ALL,mappedBy = "category")
    @JsonIgnore
//    @JoinColumn(name = "RENDEZVOUS_ID_RENDEZVOUS", nullable=true)
    private List<Client> clients;

    public Category() {
    }

    public Category(Integer idCategory, String dateCategory, String rapportCategory, Double prixCategory, List<Client> clients) {
        this.idCategory = idCategory;
        this.dateCategory = dateCategory;
        this.rapportCategory = rapportCategory;
        this.prixCategory = prixCategory;
        this.clients = clients;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getDateCategory() {
        return dateCategory;
    }

    public void setDateCategory(String dateCategory) {
        this.dateCategory = dateCategory;
    }

    public String getRapportCategory() {
        return rapportCategory;
    }

    public void setRapportCategory(String rapportCategory) {
        this.rapportCategory = rapportCategory;
    }

    public Double getPrixCategory() {
        return prixCategory;
    }

    public void setPrixCategory(Double prixCategory) {
        this.prixCategory = prixCategory;
    }

    public List<Client> getRendezvous() {
        return clients;
    }

    public void setRendezvous(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + idCategory +
                ", dateCategory=" + dateCategory +
                ", rapportCategory='" + rapportCategory + '\'' +
                ", prixCategory=" + prixCategory +
                '}';
    }
}
