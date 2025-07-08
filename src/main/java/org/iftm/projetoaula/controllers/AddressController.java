package org.iftm.projetoaula.controllers;

import java.util.List;
import java.util.Optional;

import org.iftm.projetoaula.entities.Address;
import org.iftm.projetoaula.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/address")
//dá permição a qualquer URI acessar a minha API
@CrossOrigin(origins="*")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping
    public ResponseEntity<List<Address>> findAll() {
        List<Address> list = addressService.findAll();
        return ResponseEntity.ok(list);
    }


    @GetMapping("/id/{id}")
    public ResponseEntity<Address> findById(@PathVariable Long id) {
        Optional<Address> address = addressService.findById(id);
        if (address.isPresent())
            return ResponseEntity.ok(address.get());
        else{
            return ResponseEntity.notFound().build();
        }
    }
    
}
