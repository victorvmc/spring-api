package br.com.api.repositories;

import br.com.api.models.Client;

import java.util.List;

public interface ClientCustomRepository {

    List<Client> searchClientCriteria(Integer id, String name, String lastName);
}
