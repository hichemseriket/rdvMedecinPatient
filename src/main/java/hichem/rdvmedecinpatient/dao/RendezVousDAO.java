package hichem.rdvmedecinpatient.dao;

import hichem.rdvmedecinpatient.entity.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@Service
@Repository
public interface RendezVousDAO extends JpaRepository<RendezVous, Integer> {
    RendezVous findByIdRdv(int idRendezVous);
}
