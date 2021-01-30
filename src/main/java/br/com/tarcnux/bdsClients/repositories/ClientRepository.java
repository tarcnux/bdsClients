package br.com.tarcnux.bdsClients.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tarcnux.bdsClients.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
