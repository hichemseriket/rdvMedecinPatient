package hichem.rdvmedecinpatient.controller;

import hichem.rdvmedecinpatient.dao.MedecinDAO;
import hichem.rdvmedecinpatient.dao.PatientDAO;
import hichem.rdvmedecinpatient.entity.Medecin;
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
public class MedecinController {

    public MedecinController(MedecinDAO medecinDAO) {
        this.medecinDAO = medecinDAO;
    }

    @Autowired
    private final MedecinDAO medecinDAO;

    @ApiOperation(value = "affiche la liste de tout les medecins")
    @RequestMapping(value="/medecin", method= RequestMethod.GET)
    public List<String> listeMedecin() {
        List<String> valeur = new ArrayList<>();
        List<Medecin> medecin = medecinDAO.findAll();
        for (Medecin medecin1 : medecin){
            valeur.add(medecin1.getNom());
        }
        return valeur;
    }
    //Récupérer un medecin par son Id
    @ApiOperation(value = "Réecupère un medecin selon son ID")
    @GetMapping(value = "/medecin/{id}")
    public double afficherUnMedecin(@PathVariable int id) {
        Medecin medecin = medecinDAO.findByIdMedecin(id);
        return medecin.getNom().hashCode();
    }

    //ajouter un medecin
    @ApiOperation(value = "Permet d'ajouter un medecin a la liste des medecins")
    @PostMapping(value = "/medecin")
    public ResponseEntity<Void> ajouterMedecin(@RequestBody Medecin medecin) {
        Medecin medecin1 = medecinDAO.save(medecin);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{i}")
                .buildAndExpand(medecin1.getNom())
                .toUri();
        return ResponseEntity.created(location).build();

    }
}
