package org.iftm.projetoaula.repositories;

import java.util.ArrayList;

import org.iftm.projetoaula.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

    public ArrayList<Client> findByChildren(int children);

    public ArrayList<Client> findByName(String name);

    public ArrayList<Client> findByNameAndChildren(String string, int i);

    public ArrayList<Client> findByNameOrChildren(String string, int i);

    public ArrayList<Client> findDistinctByChildren(Integer children);

    public ArrayList<Client> findByChildrenGreaterThan(int i);

    public ArrayList<Client> findByChildrenGreaterThanEqual(int i);

    public ArrayList<Client> findByChildrenBetween(int i, int j);

    public ArrayList<Client> findByNameLike(String string);

    public ArrayList<Client> findByNameContaining(String string);

    public ArrayList<Client> findByNameContainingOrderByChildren(String string);

    public ArrayList<Client> findByNameContainingOrderByChildrenDesc(String string);

    public ArrayList<Client> findByChildrenIn(ArrayList<Integer> idades);
    
}
