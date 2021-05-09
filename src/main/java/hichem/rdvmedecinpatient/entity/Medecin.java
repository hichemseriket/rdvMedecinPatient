package hichem.rdvmedecinpatient.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class Medecin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMedecin;
    private String nom;
    private String specialite;
    private String email;
    @ManyToMany(mappedBy = "medecin")
    @JsonIgnore
    private List<Rendezvous> rendezvous;

    public Medecin() {
    }

    public Medecin(Integer idMedecin, String nom, String specialite, String email, List<Rendezvous> rendezvous) {
        this.idMedecin = idMedecin;
        this.nom = nom;
        this.specialite = specialite;
        this.email = email;
        this.rendezvous = rendezvous;
    }

    public Integer getIdMedecin() {
        return idMedecin;
    }

    public void setIdMedecin(Integer idMedecin) {
        this.idMedecin = idMedecin;
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

    public List<Rendezvous> getRendezvous() {
        return rendezvous;
    }

    public void setRendezvous(List<Rendezvous> rendezVous) {
        this.rendezvous = rendezVous;
    }

    @Override
    public String toString() {
        return "Medecin{" +
                "id=" + idMedecin +
                ", nom='" + nom + '\'' +
                ", specialite='" + specialite + '\'' +
                ", email='" + email + '\'' +
                ", rendezVous=" + rendezvous +
                '}';
    }
}