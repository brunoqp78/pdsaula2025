package org.iftm.projetoaula.services;

import java.util.List;
import java.util.Optional;

import org.iftm.projetoaula.entities.Address;
import org.iftm.projetoaula.repositories.AddressRepository;
import org.iftm.projetoaula.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddressService {
    @Autowired 
    private AddressRepository addressRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public List<Address> findAll(){
        return  addressRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Address> findById(Long id){
        return addressRepository.findById(id);
    }
}
