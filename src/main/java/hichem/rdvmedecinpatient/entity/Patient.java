package hichem.rdvmedecinpatient.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPatient;
    private String nom;
    private String email;
    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    private Collection<RendezVous> rendezVous;

    public Patient() {
    }

    public Patient(Integer idPatient, String nom, String email, Collection<RendezVous> rendezVous) {
        this.idPatient = idPatient;
        this.nom = nom;
        this.email = email;
        this.rendezVous = rendezVous;
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

    public Collection<RendezVous> getRendezVous() {
        return rendezVous;
    }

    public void setRendezVous(Collection<RendezVous> rendezVous) {
        this.rendezVous = rendezVous;
    }

//    @Override
//    public String toString() {
//        return "Patient{" +
//                "id=" + idPatient +
//                ", nom='" + nom + '\'' +
//                ", email='" + email + '\'' +
//                ", rendezVous=" + rendezVous +
//                '}';
//    }
}
