package hichem.rdvmedecinpatient.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

public class Medecin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMedecin;
    private String nom;
    private String specialite;
    private String email;
    @OneToMany(mappedBy = "medecin")
    @JsonIgnore
    private Collection<RendezVous> rendezVous;

    public Medecin() {
    }

    public Medecin(Integer idMedecin, String nom, String specialite, String email, Collection<RendezVous> rendezVous) {
        this.idMedecin = idMedecin;
        this.nom = nom;
        this.specialite = specialite;
        this.email = email;
        this.rendezVous = rendezVous;
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

    public Collection<RendezVous> getRendezVous() {
        return rendezVous;
    }

    public void setRendezVous(Collection<RendezVous> rendezVous) {
        this.rendezVous = rendezVous;
    }

//    @Override
//    public String toString() {
//        return "Medecin{" +
//                "id=" + idMedecin +
//                ", nom='" + nom + '\'' +
//                ", specialite='" + specialite + '\'' +
//                ", email='" + email + '\'' +
//                ", rendezVous=" + rendezVous +
//                '}';
//    }
}