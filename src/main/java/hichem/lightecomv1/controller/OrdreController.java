package hichem.lightecomv1.controller;

import hichem.lightecomv1.dao.OrdreDAO;
import hichem.lightecomv1.entity.Ordere;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
//ordre ancienement patient
@Api(" Gestion des CATEGORY")
@RestController
@CrossOrigin(origins = "*")
public class OrdreController {

    public OrdreController(OrdreDAO ordreDAO) {
        this.ordreDAO = ordreDAO;
    }

    @Autowired
    private final OrdreDAO ordreDAO;


    @ApiOperation(value = "affiche la liste de tout les patients")
    @RequestMapping(value="/ordre", method= RequestMethod.GET)
    public List<String> listeOrdre() {
        List<String> valeur = new ArrayList<>();
        List<Ordere> ordere = ordreDAO.findAll();
        for (Ordere ordere1 : ordere){
            valeur.add(ordere1.toString());
        }
        return valeur;
    }

    //Récupérer un Ordre par son Id
    @ApiOperation(value = "Réecupère un Ordre selon son ID")
    @GetMapping(value = "/ordre/{id}")
    public double afficherUnOrdre(@PathVariable int id) {
        Ordere ordere = ordreDAO.findByIdOrdre(id);
        return ordere.toString().hashCode();
    }

    //ajouter un Ordre
    @ApiOperation(value = "Permet d'ajouter un Ordre a la liste des Ordres")
    @PostMapping(value = "/ordre")
    public ResponseEntity<Void> ajouterOrdre(@RequestBody Ordere ordere) {
        Ordere ordere1 = ordreDAO.save(ordere);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{i}")
                .buildAndExpand(ordere1.toString())
                .toUri();
        return ResponseEntity.created(location).build();

    }

}
