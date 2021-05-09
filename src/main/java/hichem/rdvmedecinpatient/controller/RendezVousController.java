package hichem.rdvmedecinpatient.controller;
import hichem.rdvmedecinpatient.dao.RendezVousDAO;
import hichem.rdvmedecinpatient.entity.RendezVous;
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
public class RendezVousController {
    @Autowired
    private RendezVousDAO rendezVousDAO;

    @ApiOperation(value = "affiche la liste de tout les rdv")
    @RequestMapping(value="/rdv", method= RequestMethod.GET)
    public List<String> listeRdv() {
        List<String> valeur = new ArrayList<>();
        List<RendezVous> rendezVous = rendezVousDAO.findAll();
        for (RendezVous rendezVous1 : rendezVous){
            valeur.add(rendezVous1.getConsultation().getRapportConsultation());
        }
        return valeur;
    }

    //Récupérer un rdv par son Id
    @ApiOperation(value = "Réecupère un rdv selon son ID")
    @GetMapping(value = "/rdv/{id}")
    public double afficherUnRdv(@PathVariable int id){
        RendezVous rendezVous = rendezVousDAO.findByIdRdv(id);
        return rendezVous.getIdRendezVous();
    }


    //ajouter une note
    @ApiOperation(value = "Permet d'ajouter un rdv a la liste des rdv")
    @PostMapping(value = "/rdv")
    public ResponseEntity<Void> ajouterRdv(@RequestBody RendezVous rendezVous) {
        RendezVous rendezVous1 = rendezVousDAO.save(rendezVous);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{i}")
                .buildAndExpand(rendezVous1.getConsultation())
                .toUri();
        return ResponseEntity.created(location).build();

    }

}
