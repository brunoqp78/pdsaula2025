package org.iftm.projetoaula.repositories;

import org.iftm.projetoaula.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
}
