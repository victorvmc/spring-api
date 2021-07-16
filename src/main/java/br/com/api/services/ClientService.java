package br.com.api.services;

import br.com.api.models.Client;

import java.util.List;

public interface ClientService {

    public Client createClients(Client client);

    public List<Client> getClients();


}
