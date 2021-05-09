package hichem.rdvmedecinpatient.entity;

import javax.persistence.*;

@Entity
public class Rendezvous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = true)
    private Integer idRendezvous;
    private String dateRendezvous;

    @ManyToOne
    private Medecin medecin;

    @ManyToOne
    private Patient patient;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="CONSULTATION_ID_CONSULTATION", nullable=true)
    private Consultation consultation;

    public Rendezvous() {
    }

    public Rendezvous(Integer idRendezvous, String dateRendezvous, Medecin medecin, Patient patient, Consultation consultation) {
        this.idRendezvous = idRendezvous;
        this.dateRendezvous = dateRendezvous;
        this.medecin = medecin;
        this.patient = patient;
        this.consultation = consultation;
    }

    public Integer getIdRendezvous() {
        return idRendezvous;
    }

    public void setIdRendezvous(Integer idRendezVous) {
        this.idRendezvous = idRendezVous;
    }

    public String getDateRendezvous() {
        return dateRendezvous;
    }

    public void setDateRendezvous(String dateRendezVous) {
        this.dateRendezvous = dateRendezVous;
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
//                "idRendezVous=" + idRendezVous +
//                ", dateRendezVous=" + dateRendezVous +
//                ", medecin=" + medecin +
//                ", patient=" + patient +
//                ", consultation=" + consultation +
//                '}';
//    }
}
