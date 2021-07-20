package br.com.api.repositories;

import br.com.api.models.Client;
import br.com.api.models.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TransferRepository extends JpaRepository<Transfer, Integer> {

    List<Transfer> findByClient(Client client);

}
