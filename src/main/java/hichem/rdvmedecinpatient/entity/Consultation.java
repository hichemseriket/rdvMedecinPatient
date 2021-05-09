package hichem.rdvmedecinpatient.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;

@Entity
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idConsultation;
    private String dateConsultation;
    private String rapportConsultation;
    private Double prixConsultation;
    @OneToOne(cascade=ALL,mappedBy = "consultation")
    @JsonIgnore
    @JoinColumn(name = "RENDEZVOUS_ID_RENDEZVOUS")
    private Rendezvous rendezvous;

    public Consultation() {
    }

    public Consultation(Integer idConsultation, String dateConsultation, String rapportConsultation, Double prixConsultation, Rendezvous rendezvous) {
        this.idConsultation = idConsultation;
        this.dateConsultation = dateConsultation;
        this.rapportConsultation = rapportConsultation;
        this.prixConsultation = prixConsultation;
        this.rendezvous = rendezvous;
    }

    public Integer getIdConsultation() {
        return idConsultation;
    }

    public void setIdConsultation(Integer idConsultation) {
        this.idConsultation = idConsultation;
    }

    public String getDateConsultation() {
        return dateConsultation;
    }

    public void setDateConsultation(String dateConsultation) {
        this.dateConsultation = dateConsultation;
    }

    public String getRapportConsultation() {
        return rapportConsultation;
    }

    public void setRapportConsultation(String rapportConsultation) {
        this.rapportConsultation = rapportConsultation;
    }

    public Double getPrixConsultation() {
        return prixConsultation;
    }

    public void setPrixConsultation(Double prixConsultation) {
        this.prixConsultation = prixConsultation;
    }

    public Rendezvous getRendezvous() {
        return rendezvous;
    }

    public void setRendezvous(Rendezvous rendezVous) {
        this.rendezvous = rendezVous;
    }

    @Override
    public String toString() {
        return "Consultation{" +
                "id=" + idConsultation +
                ", dateConsultation=" + dateConsultation +
                ", rapportConsultation='" + rapportConsultation + '\'' +
                ", prixConsultation=" + prixConsultation +
                '}';
    }
}
