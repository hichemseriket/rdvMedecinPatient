package hichem.rdvmedecinpatient.entity;

import javax.persistence.*;
import java.util.Date;

public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRendezVous;
    private Date dateRendezVous;
    @ManyToOne
    private Medecin medecin;
    @ManyToOne
    private Patient patient;
    @OneToOne
    private Consultation consultation;

    public RendezVous() {
    }

    public RendezVous(Integer idRendezVous, Date dateRendezVous, Medecin medecin, Patient patient, Consultation consultation) {
        this.idRendezVous = idRendezVous;
        this.dateRendezVous = dateRendezVous;
        this.medecin = medecin;
        this.patient = patient;
        this.consultation = consultation;
    }

    public Integer getIdRendezVous() {
        return idRendezVous;
    }

    public void setIdRendezVous(Integer idRendezVous) {
        this.idRendezVous = idRendezVous;
    }

    public Date getDateRendezVous() {
        return dateRendezVous;
    }

    public void setDateRendezVous(Date dateRendezVous) {
        this.dateRendezVous = dateRendezVous;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

    //    @Override
//    public String toString() {
//        return "RendezVous{" +
//                "id=" + id +
//                ", dateRendezVous=" + dateRendezVous +
//                ", consultation=" + consultation +
//                '}';
//    }
}
