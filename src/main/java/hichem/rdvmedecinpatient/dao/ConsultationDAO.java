package hichem.rdvmedecinpatient.dao;

import hichem.rdvmedecinpatient.entity.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@Service

@Repository
public interface ConsultationDAO extends JpaRepository<Consultation, Integer> {
    Consultation findByIdConsultation(int idConsultation);
}
