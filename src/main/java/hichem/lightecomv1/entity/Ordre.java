package hichem.lightecomv1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Ordre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrdre;
    private String nom;
    private String email;
    @ManyToMany(mappedBy = "ordre")
    @JsonIgnore
    private List<Client> clients;

    public Ordre() {
    }

    public Ordre(Integer idOrdre, String nom, String email, List<Client> clients) {
        this.idOrdre = idOrdre;
        this.nom = nom;
        this.email = email;
        this.clients = clients;
    }

    public Integer getIdOrdre() {
        return idOrdre;
    }

    public void setIdOrdre(Integer idOrdre) {
        this.idOrdre = idOrdre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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
        return "Ordre{" +
                "id=" + idOrdre +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", rendezVous=" + clients +
                '}';
    }
}
