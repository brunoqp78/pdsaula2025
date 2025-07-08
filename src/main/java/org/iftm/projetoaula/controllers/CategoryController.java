package org.iftm.projetoaula.controllers;

import java.util.List;
import java.util.Optional;

import org.iftm.projetoaula.entities.Category;
import org.iftm.projetoaula.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/categories")
//dá permição a qualquer URI acessar a minha API
@CrossOrigin(origins="*")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> list = categoryService.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        Optional<Category> category = categoryService.findById(id);
        if (category.isPresent())
            return ResponseEntity.ok(category.get());
        else{
            return ResponseEntity.notFound().build();
        }
    }
    
}
