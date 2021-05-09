package hichem.rdvmedecinpatient.controller;
import hichem.rdvmedecinpatient.dao.ConsultationDAO;
import hichem.rdvmedecinpatient.entity.Consultation;
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
public class ConsultationController {
    @Autowired
    private ConsultationDAO consultationDAO;

    @ApiOperation(value = "affiche la liste de toutes les consult")
    @RequestMapping(value="/consultation", method= RequestMethod.GET)
    public List<String> listeConsultation() {
        List<String> valeur = new ArrayList<>();
        List<Consultation> consultation = consultationDAO.findAll();
        for (Consultation consultation1 : consultation){
            valeur.add(consultation1.getRapportConsultation());
        }
        return valeur;
    }

    //Récupérer une consultation par son Id
    @ApiOperation(value = "Réecupère une consultation par son ID")
    @GetMapping(value = "/consultation/{id}")
    public double afficherUnConsultation(@PathVariable int id)  {
        Consultation consultation = consultationDAO.findByIdConsultation(id);
        return consultation.getIdConsultation();
    }

    //ajouter une consultation
    @ApiOperation(value = "Permet d'ajouter une consulatation a la liste des consultation")
    @PostMapping(value = "/consultation")
    public ResponseEntity<Void> ajouterConsultation(@RequestBody Consultation consultation) {
        Consultation consultation1 = consultationDAO.save(consultation);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{i}")
                .buildAndExpand(consultation1.getRapportConsultation())
                .toUri();
        return ResponseEntity.created(location).build();

    }
}
