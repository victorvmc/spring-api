package br.com.api.resources;

import br.com.api.dto.inputs.ClientInputDTO;
import br.com.api.dto.outputs.ClientOutputDTO;
import br.com.api.models.Client;
import br.com.api.services.ClientService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@RestController
@RequestMapping(value = "/api")
public class ClientResource {

    @Autowired
    private ClientService clientService;

    @PostMapping("/client")
    public ResponseEntity<ClientOutputDTO> createClient(@RequestBody ClientInputDTO clientInputDTO) {

        Client clientSaved = clientService.createClient(new Client(clientInputDTO.getName(), clientInputDTO.getLastName()));

        return new ResponseEntity<>(new ClientOutputDTO(clientSaved), HttpStatus.CREATED);
    }

    @GetMapping("/clients")
    public ResponseEntity<List<ClientOutputDTO>> readClients(@PageableDefault(page = 0, size = 2, sort = "name", direction = Sort.Direction.ASC) Pageable pageable) {

        Page<Client> clientsList = clientService.getClients(pageable);

        return new ResponseEntity<>(clientsList.stream().map(ClientOutputDTO::new).collect(Collectors.toList()), HttpStatus.ACCEPTED);
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<ClientOutputDTO> readClient(@PathVariable("id") Integer id) {

        Client clientById = clientService.getClientById(id);

        return new ResponseEntity<>(new ClientOutputDTO(clientById), HttpStatus.ACCEPTED);
    }

    @PutMapping("/client/{id}")
    public ResponseEntity<ClientOutputDTO> updateClient(@PathVariable("id") Integer id, @RequestBody ClientInputDTO clientUpdateDTO) {

        Client clientUpdated = clientService.updateClient(new Client(id, clientUpdateDTO.getName(), clientUpdateDTO.getLastName()));

        return new ResponseEntity<>(new ClientOutputDTO(clientUpdated), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/client/{id}")
    public void deleteClient(@PathVariable("id") Integer id) {
        clientService.deleteClient(id);
    }

    @GetMapping("/client/name/{name}")
    public ResponseEntity<ClientOutputDTO> getClientByName(@PathVariable("name") String name) {
        return new ResponseEntity<>(new ClientOutputDTO(clientService.getClientByName(name)), HttpStatus.ACCEPTED);
    }

}
