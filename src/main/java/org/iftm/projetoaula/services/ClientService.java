package org.iftm.projetoaula.services;

import org.iftm.projetoaula.entities.Client;
import org.iftm.projetoaula.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class ClientService {
    //injeção de dependência
    @Autowired
    private ClientRepository repositorio;

    @Transactional
    public Client insert(Client client){
        validateName(client.getName());
        return repositorio.save(client);
        /*
        if (client.getName().length() >=2 && client.getName().length()<=200){
            return repositorio.save(client);
        }else{
            throw new IllegalArgumentException("Nome inválido!!! O nome precisa ter entre 2 e 200 caracteres.");
        }
        */
    }

    private void validateName(String nome){
        if (nome.length() < 2 || nome.length()>200){
            throw new IllegalArgumentException("Nome inválido!!! O nome precisa ter entre 2 e 200 caracteres.");
        }
        char primeiraLetra = nome.charAt(0);
        if (primeiraLetra >= '0' && primeiraLetra<= '9'){
            throw new IllegalArgumentException("Nome inválido!!! O nome não pode começar com números.");
        }
    }
}
