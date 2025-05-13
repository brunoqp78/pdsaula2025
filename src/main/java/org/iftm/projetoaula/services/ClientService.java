package org.iftm.projetoaula.services;

import java.util.List;
import java.util.Optional;

import org.iftm.projetoaula.entities.Client;
import org.iftm.projetoaula.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {
    //injeção de dependência
    @Autowired
    private ClientRepository repositorio;

    // Regra: Listar todos os clientes
    @Transactional(readOnly = true)
    public List<Client> findAll() {
        return repositorio.findAll();
    }

    // Regra: Buscar cliente por ID
    @Transactional(readOnly = true)
    public Optional<Client> findById(Long id) {
        return repositorio.findById(id);
    }

    // Regra: Buscar cliente por ID
    @Transactional(readOnly = true)
    public List<Client> findByName(String name) {
        return repositorio.findByName(name);
    }


    // Regra: Inserir cliente com validações
    @Transactional
    public Client insert(Client client) {
        validateIncome(client.getIncome());
        validateChildren(client.getChildren());
        validateName(client.getName());
        return repositorio.save(client);
    }

    // Regra: Atualizar cliente com validações
    @Transactional
    public Client update(Long id, Client updatedClient) {
    Client entity = repositorio.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
        validateIncome(updatedClient.getIncome());
        validateChildren(updatedClient.getChildren());
        validateName(updatedClient.getName());
        entity.setName(updatedClient.getName());
        entity.setCpf(updatedClient.getCpf());
        entity.setIncome(updatedClient.getIncome());
        entity.setBirthDate(updatedClient.getBirthDate());
        entity.setChildren(updatedClient.getChildren());
        return repositorio.save(entity);
    }

    // Regra: Deletar cliente
    @Transactional
    public void delete(Long id) {
        repositorio.deleteById(id);
    }

    // Regra de validação: Verificar renda mínima
    private void validateIncome(Double income) {
        if (income < 1000.0) {
            throw new IllegalArgumentException("Income must be at least R$ 1,000.00");
        }
    }

    // Regra de validação: Limitar número de filhos
    private void validateChildren(Integer children) {
        if (children > 10) {
            throw new IllegalArgumentException("Clients can have at most 10 children.");
        }
    }

    // Regra adicional: Recomendar crédito com base em renda e filhos
    public String recommendCredit(Long id) {
        Client client = repositorio.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
        double factor = client.getIncome() / (client.getChildren() + 1);
        if (factor > 5000) {
            return "High credit limit recommended.";
        } else if (factor > 2000) {
            return "Medium credit limit recommended.";
        } else {
            return "Low credit limit recommended.";
        }
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
