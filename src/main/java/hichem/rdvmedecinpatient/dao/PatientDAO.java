package hichem.rdvmedecinpatient.dao;

import hichem.rdvmedecinpatient.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@Service

@Repository
public interface PatientDAO extends JpaRepository<Patient, Integer> {
    Patient findByIdPatient(int idPatient);
}
