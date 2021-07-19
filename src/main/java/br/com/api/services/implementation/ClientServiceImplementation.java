package br.com.api.services.implementation;

import br.com.api.models.Client;
import br.com.api.repositories.ClientRepository;
import br.com.api.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImplementation implements ClientService {

    @Autowired
    ClientRepository clientRepository;


    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClienteById(Integer id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.orElse(null);
    }

    @Override
//    TODO É necessário criar esse método igual do create?
//    TODO Tratamento de erro para não criar quando não existir
    public Client updateClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void deleteClient(Integer id) {
        clientRepository.deleteById(id);
    }


}
