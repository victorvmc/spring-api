package br.com.api.services;

import br.com.api.models.Client;
import br.com.api.repositories.ClientCustomRepositoryImpl;
import br.com.api.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientCustomRepositoryImpl clientCustomRepository;

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Page<Client> getClients(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }

    public Client getClientById(Integer id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.orElse(null);
    }

    public Client updateClient(Client client) {
        return clientRepository.save(client);
    }

    public void deleteClient(Integer id) {
        clientRepository.deleteById(id);
    }

    public Client getClientByName(String name) {
        return clientRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Client> getClientCriteria(Integer id, String name, String lastName) {
        return clientCustomRepository.searchClientCriteria(id, name, lastName);
    }
}
