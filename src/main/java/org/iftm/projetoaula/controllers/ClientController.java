package org.iftm.projetoaula.controllers;

import java.util.List;
import java.util.Optional;

import org.iftm.projetoaula.entities.Client;
import org.iftm.projetoaula.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



//anotação que define a criação de uma APIRest
@RestController
//anotação que define o endereço(URI) no qual a api irá responder
//localhost:8080/clients
@RequestMapping("/clients")
//dá permição a qualquer URI acessar a minha API
@CrossOrigin(origins="*")
public class ClientController {

    //fazer injeção de dependencia da classe da camada Service
    @Autowired
    private ClientService service;

    //define o método que irá responder(endpoint) a requisição raiz(localhost:8080/clients)
    @GetMapping
    public ResponseEntity<List<Client>> findAll() {
        List<Client> clients= service.findAll();
        if (clients.isEmpty()==false){
            return ResponseEntity.ok(clients);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Client>> findByName(@PathVariable String name) {
        List<Client> clients= service.findByName(name);
        if (clients.isEmpty()==false){
            return ResponseEntity.ok(clients);
        }
        else{
            System.out.println(name);
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
    
    @PostMapping
    public ResponseEntity<Client> create(@RequestBody Client client) {
        try{
            Client clientSave = service.insert(client);        
            return ResponseEntity.ok(clientSave);
        }catch(DataIntegrityViolationException e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<Client> update(@RequestBody Client client) {
        try{
            Client clientUpdate = service.update(client.getId(), client);        
            return ResponseEntity.ok(clientUpdate);
        }catch(DataIntegrityViolationException e){
            return ResponseEntity.badRequest().build();
        }
    }    

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        try {
            service.delete(id);
            return "Client delete sucessfull!!";
        } catch (Exception e) {
            return e.getMessage();
        }        
    }
}
