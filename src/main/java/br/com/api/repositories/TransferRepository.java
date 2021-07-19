package br.com.api.repositories;

import br.com.api.models.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TransferRepository extends JpaRepository<Transfer, Integer> {
}
