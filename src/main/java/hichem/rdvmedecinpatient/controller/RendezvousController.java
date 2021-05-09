package hichem.rdvmedecinpatient.controller;
import hichem.rdvmedecinpatient.dao.RendezvousDAO;
import hichem.rdvmedecinpatient.entity.Rendezvous;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Api(description = " Gestion des RDV CONSULTATION")
@RestController
@CrossOrigin(origins = "*")
public class RendezvousController {
    @Autowired
    private RendezvousDAO rendezvousDAO;

    @ApiOperation(value = "affiche la liste de tout les rdv")
    @RequestMapping(value="/rdv", method= RequestMethod.GET)
    public List<String> listeRdv() {
        List<String> valeur = new ArrayList<>();
        List<Rendezvous> rendezvous = rendezvousDAO.findAll();
        for (Rendezvous rendezvous1 : rendezvous){
            valeur.add(rendezvous1.getConsultation().getRapportConsultation());
        }
        return valeur;
    }

    //Récupérer un rdv par son Id
    @ApiOperation(value = "Réecupère un rdv selon son ID")
    @GetMapping(value = "/rdv/{id}")
    public double afficherUnRdv(@PathVariable int id){
        Rendezvous rendezvous = rendezvousDAO.findByIdRendezvous(id);
        return rendezvous.getIdRendezvous();
    }


    //ajouter une note
    @ApiOperation(value = "Permet d'ajouter un rdv a la liste des rdv")
    @PostMapping(value = "/rdv")
    public ResponseEntity<Void> ajouterRdv(@RequestBody Rendezvous rendezvous) {
        Rendezvous rendezvous1 = rendezvousDAO.save(rendezvous);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{i}")
                .buildAndExpand(rendezvous1.getConsultation())
                .toUri();
        return ResponseEntity.created(location).build();

    }

}
