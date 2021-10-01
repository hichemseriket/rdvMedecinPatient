package hichem.lightecomv1.controller;

import hichem.lightecomv1.dao.ProductDAO;
import hichem.lightecomv1.entity.Product;
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
public class ProductController {

    public ProductController(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Autowired
    private final ProductDAO productDAO;

    @ApiOperation(value = "affiche la liste de tout les Products")
    @RequestMapping(value="/product", method= RequestMethod.GET)
    public List<String> listeProduct() {
        List<String> valeur = new ArrayList<>();
        List<Product> product = productDAO.findAll();
        for (Product product1 : product){
            valeur.add(product1.toString());
        }
        return valeur;
    }
    //Récupérer un Product par son Id
    @ApiOperation(value = "Réecupère un Product selon son ID")
    @GetMapping(value = "/product/{id}")
    public String afficherUnProduct(@PathVariable int id) {
        Product product = productDAO.findByIdProduct(id);
//        return product.getNom().hashCode();
        return product.getName();
    }

    //ajouter un Product
    @ApiOperation(value = "Permet d'ajouter un Product a la liste des Products")
    @PostMapping(value = "/product")
    public ResponseEntity<Void> ajouterProduct(@RequestBody Product product) {
        Product product1 = productDAO.save(product);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{i}")
                .buildAndExpand(product1.getName())
                .toUri();
        return ResponseEntity.created(location).build();

    }
}
