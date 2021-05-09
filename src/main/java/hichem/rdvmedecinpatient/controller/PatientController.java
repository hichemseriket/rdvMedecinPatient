package hichem.rdvmedecinpatient.controller;

import hichem.rdvmedecinpatient.dao.PatientDAO;
import hichem.rdvmedecinpatient.entity.Patient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Api(" Gestion des RDV CONSULTATION")
@RestController
@CrossOrigin(origins = "*")
public class PatientController {
    @Autowired
    private PatientDAO patientDAO;


    @ApiOperation(value = "affiche la liste de tout les patients")
    @RequestMapping(value="/patient", method= RequestMethod.GET)
    public List<String> listePatient() {
        List<String> valeur = new ArrayList<>();
        List<Patient> patient = patientDAO.findAll();
        for (Patient patient1 : patient){
            valeur.add(patient1.getNom());
        }
        return valeur;
    }

    //Récupérer un patient par son Id
    @ApiOperation(value = "Réecupère un patient selon son ID")
    @GetMapping(value = "/patient/{id}")
    public double afficherUnPatient(@PathVariable int id) {
        Patient patient = patientDAO.findByIdPatient(id);
        return patient.getNom().hashCode();
    }

    //ajouter un patient
    @ApiOperation(value = "Permet d'ajouter un patient a la liste des patients")
    @PostMapping(value = "/Patient")
    public ResponseEntity<Void> ajouterPatient(@RequestBody Patient patient) {
        Patient patient1 = patientDAO.save(patient);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{i}")
                .buildAndExpand(patient1.getNom())
                .toUri();
        return ResponseEntity.created(location).build();

    }

}
