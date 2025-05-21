package org.iftm.projetoaula.controllers;

import java.util.List;
import java.util.Optional;

import org.iftm.projetoaula.entities.Client;
import org.iftm.projetoaula.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//anotação que define a criação de uma APIRest
@RestController
//anotação que define o endereço(URI) no qual a api irá responder
//localhost:8080/clients
@RequestMapping("/clients")
public class ClientController {

    //fazer injeção de dependencia da classe da camada Service
    @Autowired
    private ClientService service;

    //define o método que irá responder(endpoint) a requisição raiz(localhost:8080/clients)
    @GetMapping
    public ResponseEntity<List<Client>> findAll() {
        List<Client> clients= service.findAll();
        if (clients.size()>0){
            return ResponseEntity.ok(clients);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Client>> findByName(@PathVariable String name) {
        List<Client> clients= service.findByName(name);
        if (clients.size()>0){
            return ResponseEntity.ok(clients);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    
    }
    

    @GetMapping("/id/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id) {
        Optional<Client> client = service.findById(id);
        if (client.isPresent())
            return ResponseEntity.ok(client.get());
        else{
            return ResponseEntity.notFound().build();
        }
    }

    
    

}
