package org.iftm.projetoaula.repositories;

import java.util.ArrayList;

import org.iftm.projetoaula.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

    public ArrayList<Client> findByChildren(int qtdFilhos);

    public ArrayList<Client> findByName(String nome);

    public ArrayList<Client> findByNameAndChildren(String nome, int qtdFilhos);

    public ArrayList<Client> findByNameOrChildrenOrderByName(String nome, int qtdFilhos);

    public ArrayList<Client> findByChildrenGreaterThan(int qtdFilhos);

    public ArrayList<Client> findByChildrenGreaterThanEqual(int qtdFilhos);

    public ArrayList<Client> findByChildrenBetweenOrderByName(int qtdMinima, int qtdMaxia);

    public ArrayList<Client> findByNameLike(String nome);

    public ArrayList<Client> findByNameContaining(String nome);

    public ArrayList<Client> findByNameContainingOrderByChildren(String nome);

    public ArrayList<Client> findByNameContainingOrderByChildrenDesc(String nome);

    public ArrayList<Client> findByChildrenIn(ArrayList<Integer> qtdFilhos);

    public ArrayList<Client> findByChildrenInAndIncomeGreaterThanEqualOrderByNameDesc(ArrayList<Integer> qtdFilhos, double income);

}
