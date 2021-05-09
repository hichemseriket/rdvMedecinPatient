package hichem.rdvmedecinpatient.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idConsultation;
    private Date dateConsultation;
    private String rapportConsultation;
    private Double prixConsultation;
    @OneToOne(mappedBy = "consultation")
    private RendezVous rendezVous;

    public Consultation() {
    }

    public Consultation(Integer idConsultation, Date dateConsultation, String rapportConsultation, Double prixConsultation, RendezVous rendezVous) {
        this.idConsultation = idConsultation;
        this.dateConsultation = dateConsultation;
        this.rapportConsultation = rapportConsultation;
        this.prixConsultation = prixConsultation;
        this.rendezVous = rendezVous;
    }

    public Integer getIdConsultation() {
        return idConsultation;
    }

    public void setIdConsultation(Integer idConsultation) {
        this.idConsultation = idConsultation;
    }

    public Date getDateConsultation() {
        return dateConsultation;
    }

    public void setDateConsultation(Date dateConsultation) {
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

    public RendezVous getRendezVous() {
        return rendezVous;
    }

    public void setRendezVous(RendezVous rendezVous) {
        this.rendezVous = rendezVous;
    }

//    @Override
//    public String toString() {
//        return "Consultation{" +
//                "id=" + idConsultation +
//                ", dateConsultation=" + dateConsultation +
//                ", rapportConsultation='" + rapportConsultation + '\'' +
//                ", prixConsultation=" + prixConsultation +
//                '}';
//    }
}
