package br.com.api.resources;

import br.com.api.dto.inputs.ClientInputDTO;
import br.com.api.services.mapper.ClientMapper;
import br.com.api.models.Client;
import br.com.api.services.ClientService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@NoArgsConstructor
@RestController
@RequestMapping(value = "/api")
public class ClientResource {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientMapper clientMapper;

    @PostMapping("/client")
    public ResponseEntity<Client> createClient(@RequestBody ClientInputDTO client) {

        Client clientSaved = clientService.createClients(clientMapper.mapClientDTOToClient(client));

        return ResponseEntity.status(HttpStatus.CREATED).body(clientSaved);
    }

    @GetMapping("/clients")
    public ResponseEntity<List<Client>> readClients() {

        List<Client> clients = clientService.getClients();

        return ResponseEntity.ok().body(clients);
    }

//    @GetMapping("/client/{id}")
//    public Client readClient(@PathVariable("id") Integer id) {
//
//        Optional<Client> client = clientRepository.findById(id);
//
//        return client.orElse(null);
//    }
//
//    @PutMapping("/client")
//    public Client updateClient(@RequestBody Client client) {
//        return clientRepository.save(client);
//    }
//
//    @DeleteMapping("/client/{id}")
//    public void deleteClient(@PathVariable("id") Integer id) {
//        clientRepository.deleteById(id);
//    }

}
