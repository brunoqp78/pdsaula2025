package org.iftm.projetoaula.entities;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

// anotação que indica ao JPA que essa classe é uma entidade no BD.
@Entity
// anotação que permite modificar as caracteristicas da tabela relacionada a classe
@Table(name="tb_client")
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    
    //atributos

    // anotação da chave primária da entidade no BD
    @Id
    // anotação que define a estratégia de geração de chaves automaticas
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    // anotação que permite modificar as caracteristicas do campo na tabela relacionada ao atributo da classe
    @Column(nullable=false, length=200, unique=false)
    private String name;
    @Column(nullable=false, length=14, unique=true)
    private String cpf;
    @Column(nullable=false, unique=false)
    private Double income;
    @Column(nullable=true, unique=false)
    private Instant birthDate;
    @Column(nullable=true, unique=false)
    private Integer children = 0;
    // anotação que define a não persistencia do atributo no banco de dados.
    @Transient    
    private boolean status = true;

    // 1 .. 1 -> OneToOne
    // 1 .. n -> OneToMany
    // n .. n -> ManyToMany

    // criar uma referência ao endereço do Cliente
    @OneToOne
    @JoinColumn(name = "address_fk", referencedColumnName = "id")
    @JsonIgnoreProperties("client")
    private Address address;
    
    // criar a referência para um objeto categória
    // relação de n para 1, acompanhar a direção da relação no DER.
    @ManyToOne
    @JoinColumn(nullable=false, name="category_fk", referencedColumnName="id") 
    @JsonIgnoreProperties("clients")   
    private Category category;

    //construtores
    public Client(){}

    public Client(Long id, String name, String cpf, Double income, Instant birthDate, Integer children, Address address, Category category ) {
        this.birthDate = birthDate;
        this.children = children;
        this.cpf = cpf;
        this.id = id;
        this.income = income;
        this.name = name;
        this.address = address;
        this.category = category;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    
    // outros métodos

    
}
