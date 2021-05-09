package hichem.rdvmedecinpatient.dao;

import hichem.rdvmedecinpatient.entity.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@Service

@Repository
public interface MedecinDAO extends JpaRepository<Medecin,Integer> {
    Medecin findByIdMedecin(int idMedecin);
}
