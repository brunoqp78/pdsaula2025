package org.iftm.projetoaula.entities;

import java.io.Serializable;
import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// anotação que indica ao JPA que essa classe é uma entidade no BD.
@Entity
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    
    //atributos

    // anotação da chave primária da entidade no BD
    @Id
    // anotação que define a estratégia de geração de chaves automaticas
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String cpf;
    private Double income;
    private Instant birthDate;
    private Integer children;
    
    //construtores
    public Client(){}

    public Client(Instant birthDate, Integer children, String cpf, Long id, Double income, String name) {
        this.birthDate = birthDate;
        this.children = children;
        this.cpf = cpf;
        this.id = id;
        this.income = income;
        this.name = name;
    }


    //métodos setters and getters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Instant getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Instant birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }

    // outros métodos

    
}
