package hichem.lightecomv1.dao;

import hichem.lightecomv1.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// client avant RDV
@Repository
public interface ClientDAO extends JpaRepository<Client, Integer> {
    Client findByIdClient(int idClient);
}
