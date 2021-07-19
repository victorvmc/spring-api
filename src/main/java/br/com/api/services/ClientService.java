package br.com.api.services;

import br.com.api.models.Client;

import java.util.List;

public interface ClientService {

    public Client createClient(Client client);

    public List<Client> getClients();

    public Client getClienteById(Integer id);

    public Client updateClient(Client client);

    public void deleteClient(Integer id);

}
