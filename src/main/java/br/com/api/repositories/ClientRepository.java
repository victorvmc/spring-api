package br.com.api.repositories;

import br.com.api.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer>{

    Client findByNameContainingIgnoreCase(String name);

}
