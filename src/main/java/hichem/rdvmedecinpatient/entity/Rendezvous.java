package hichem.rdvmedecinpatient.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Rendezvous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = true)
    private Integer idRendezvous;
    private String dateRendezvous;

    @ManyToMany
    private List<Medecin> medecin;

    @ManyToMany
    private List<Patient> patient;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="CONSULTATION_ID_CONSULTATION", nullable=true)
    private List<Consultation> consultation;

    public Rendezvous() {
    }

    public Rendezvous(Integer idRendezvous, String dateRendezvous, List<Medecin> medecin, List<Patient> patient, List<Consultation> consultation) {
        this.idRendezvous = idRendezvous;
        this.dateRendezvous = dateRendezvous;
        this.medecin = medecin;
        this.patient = patient;
        this.consultation = consultation;
    }

    //    public Rendezvous(Integer idRendezvous, String dateRendezvous, Medecin medecin, List<Patient> patient, List<Consultation> consultation) {
//        this.idRendezvous = idRendezvous;
//        this.dateRendezvous = dateRendezvous;
//        this.medecin = medecin;
//        this.patient = patient;
//        this.consultation = consultation;
//    }

    public Integer getIdRendezvous() {
        return idRendezvous;
    }

    public void setIdRendezvous(Integer idRendezvous) {
        this.idRendezvous = idRendezvous;
    }

    public String getDateRendezvous() {
        return dateRendezvous;
    }

    public void setDateRendezvous(String dateRendezvous) {
        this.dateRendezvous = dateRendezvous;
    }

    public List<Medecin> getMedecin() {
        return medecin;
    }

    public void setMedecin(List<Medecin> medecin) {
        this.medecin = medecin;
    }
    //
//    public Medecin getMedecin() {
//        return medecin;
//    }
//
//    public void setMedecin(Medecin medecin) {
//        this.medecin = medecin;
//    }

    public List<Patient> getPatient() {
        return patient;
    }

    public void setPatient(List<Patient> patient) {
        this.patient = patient;
    }

    public List<Consultation> getConsultation() {
        return consultation;
    }

    public void setConsultation(List<Consultation> consultation) {
        this.consultation = consultation;
    }

    @Override
    public String toString() {
        return "Rendezvous{" +
                "idRendezvous=" + idRendezvous +
                ", dateRendezvous='" + dateRendezvous + '\'' +
                ", medecin=" + medecin +
                ", patient=" + patient +
                ", consultation=" + consultation +
                '}';
    }
}
