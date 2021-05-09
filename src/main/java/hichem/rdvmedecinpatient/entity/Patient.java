package hichem.rdvmedecinpatient.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPatient;
    private String nom;
    private String email;
    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    private List<Rendezvous> rendezvous;

    public Patient() {
    }

    public Patient(Integer idPatient, String nom, String email, List<Rendezvous> rendezvous) {
        this.idPatient = idPatient;
        this.nom = nom;
        this.email = email;
        this.rendezvous = rendezvous;
    }

    public Integer getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Integer idPatient) {
        this.idPatient = idPatient;
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

    public List<Rendezvous> getRendezvous() {
        return rendezvous;
    }

    public void setRendezvous(List<Rendezvous> rendezVous) {
        this.rendezvous = rendezVous;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + idPatient +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", rendezVous=" + rendezvous +
                '}';
    }
}
