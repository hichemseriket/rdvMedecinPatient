package hichem.lightecomv1.controller;
import hichem.lightecomv1.dao.ClientDAO;
import hichem.lightecomv1.entity.Client;
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
public class ClientController {
    @Autowired
    private ClientDAO clientDAO;

    @ApiOperation(value = "affiche la liste de tout les Client")
    @RequestMapping(value="/client", method= RequestMethod.GET)
    public List<String> listeClient() {
        List<String> valeur = new ArrayList<>();
        List<Client> clients = clientDAO.findAll();
        for (Client client1 : clients){
            valeur.add(client1.getDateClient());
        }
        return valeur;
    }

    //Récupérer un Client par son Id
    @ApiOperation(value = "Réecupère un Client selon son ID")
    @GetMapping(value = "/client/{id}")
    public double afficherUnClient(@PathVariable int id){
        Client client = clientDAO.findByIdClient(id);
        return client.getIdClient();
    }


    //ajouter une note
    @ApiOperation(value = "Permet d'ajouter un Client a la liste des Client")
    @PostMapping(value = "/Client")
    public ResponseEntity<Void> ajouterClient(@RequestBody Client client) {
        Client client1 = clientDAO.save(client);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{i}")
                .buildAndExpand(client1.getCategory())
                .toUri();
        return ResponseEntity.created(location).build();

    }

}
