package br.com.api.resources;

import br.com.api.dto.inputs.ClientInputDTO;
import br.com.api.dto.outputs.ClientOutputDTO;
import br.com.api.models.Client;
import br.com.api.services.implementation.ClientServiceImplementation;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@NoArgsConstructor
@RestController
@RequestMapping(value = "/api")
public class ClientResource {

    @Autowired
    private ClientServiceImplementation clientServiceImplementation;

    @PostMapping("/client")
    public ResponseEntity<ClientOutputDTO> createClient(@RequestBody ClientInputDTO clientInputDTO) {

        Client clientSaved = clientServiceImplementation.createClient(new Client(clientInputDTO.getName(),clientInputDTO.getLastName()));
        ClientOutputDTO clientOutputDTO = new ClientOutputDTO(clientSaved);

        return ResponseEntity.status(HttpStatus.CREATED).body(clientOutputDTO);
    }

    @GetMapping("/clients")
    public ResponseEntity<List<ClientOutputDTO>> readClients() {

        List<Client> clientsList = clientServiceImplementation.getClients();
//        TODO to study
        List<ClientOutputDTO> clientsOutputDTOList = clientsList.stream().map(ClientOutputDTO::new).collect(Collectors.toList());

        return ResponseEntity.ok().body(clientsOutputDTOList);
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<ClientOutputDTO> readClient(@PathVariable("id") Integer id) {

        Client clientById = clientServiceImplementation.getClienteById(id);

        return ResponseEntity.ok().body(new ClientOutputDTO(clientById));
    }

    @PutMapping("/client")
    public ResponseEntity<ClientOutputDTO> updateClient(@RequestBody ClientInputDTO clientUpdateDTO) {

        Client clientUpdated = clientServiceImplementation
                .updateClient(new Client(clientUpdateDTO.getId(), clientUpdateDTO.getName(), clientUpdateDTO.getLastName()));

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ClientOutputDTO(clientUpdated));
    }

    @DeleteMapping("/client/{id}")
    public void deleteClient(@PathVariable("id") Integer id) {
        clientServiceImplementation.deleteClient(id);
    }

}
