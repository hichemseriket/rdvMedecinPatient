package hichem.rdvmedecinpatient.dao;

import hichem.rdvmedecinpatient.entity.Rendezvous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RendezvousDAO extends JpaRepository<Rendezvous, Integer> {
    Rendezvous findByIdRendezvous(int idRendezvous);
}
