package hichem.lightecomv1.controller;
import hichem.lightecomv1.dao.CategoryDAO;
import hichem.lightecomv1.entity.Category;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Api(description = " Gestion des  Category")
@RestController
@CrossOrigin(origins = "*")
public class CategoryController {
    @Autowired
    private CategoryDAO categoryDAO;

    @ApiOperation(value = "affiche la liste de toutes les consult")
    @RequestMapping(value="/category", method= RequestMethod.GET)
    public List<String> listeCategory() {
        List<String> valeur = new ArrayList<>();
        List<Category> category = categoryDAO.findAll();
        for (Category category1 : category){
            valeur.add(category1.getRapportCategory());
        }
        return valeur;
    }

    //Récupérer une Category par son Id
    @ApiOperation(value = "Réecupère une Category par son ID")
    @GetMapping(value = "/category/{id}")
    public double afficherUnCategory(@PathVariable int id)  {
        Category category = categoryDAO.findByIdCategory(id);
        return category.getIdCategory();
    }

    //ajouter une Category
    @ApiOperation(value = "Permet d'ajouter une consulatation a la liste des Category")
    @PostMapping(value = "/category")
    public ResponseEntity<Void> ajouterCategory(@RequestBody Category category) {
        Category category1 = categoryDAO.save(category);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{i}")
                .buildAndExpand(category1.getRapportCategory())
                .toUri();
        return ResponseEntity.created(location).build();

    }
}
