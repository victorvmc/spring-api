package br.com.api.api.resources;

import br.com.api.api.models.Client;
import br.com.api.api.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class ClientResource {

    @Autowired
    private ClientRepository clientRepository;

    @PostMapping("/client")
    public Client createClient(@RequestBody Client client){
        return clientRepository.save(client);
    }

    @GetMapping("/clients")
    public List<Client> readClients(){
        return clientRepository.findAll();
    }

    @GetMapping("/client/{id}")
    public Client readClient(@PathVariable(value = "id") Integer id){

        Optional<Client> client = clientRepository.findById(id);

        return client.orElse(null);
    }

    @PutMapping("/client")
    public Client updateClient(@RequestBody Client client){
        return clientRepository.save(client);
    }

    @DeleteMapping("/client/{id}")
    public void deleteClient(@PathVariable(value = "id") Integer id){
        clientRepository.deleteById(id);
    }

}
