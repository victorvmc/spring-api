package br.com.api.resources;

import br.com.api.models.Client;
import br.com.api.repositories.ClientRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@RestController
@RequestMapping(value = "/api")
public class ClientResource {

    @Autowired
    private ClientRepository clientRepository;

    @PostMapping("/client")
    public ResponseEntity<Client> createClient(@RequestBody Client client) {

        Client clientSaved = clientRepository.save(client);

        return ResponseEntity.status(HttpStatus.CREATED).body(clientSaved) ;
    }

//    TODO O body do responseentity e do list são diferentes
    @GetMapping("/clients")
    public List<Client> readClients() {
        return clientRepository.findAll();
    }

    @GetMapping("/client/{id}")
    public Client readClient(@PathVariable("id") Integer id) {

        Optional<Client> client = clientRepository.findById(id);

        return client.orElse(null);
    }

    @PutMapping("/client")
    public Client updateClient(@RequestBody Client client) {
        return clientRepository.save(client);
    }

    @DeleteMapping("/client/{id}")
    public void deleteClient(@PathVariable("id") Integer id) {
        clientRepository.deleteById(id);
    }

}
