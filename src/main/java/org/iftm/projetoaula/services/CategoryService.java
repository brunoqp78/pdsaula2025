package org.iftm.projetoaula.services;

import java.util.List;
import java.util.Optional;

import org.iftm.projetoaula.entities.Category;
import org.iftm.projetoaula.repositories.CategoryRepository;
import org.iftm.projetoaula.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryService {
    @Autowired 
    private CategoryRepository categoryRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public List<Category> findAll(){
        return  categoryRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Category> findById(Long id){
        return categoryRepository.findById(id);
    }    
}
