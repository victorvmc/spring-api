package br.com.api.services.mapper;

import br.com.api.dto.inputs.ClientInputDTO;
import br.com.api.models.Client;
import org.springframework.stereotype.Service;

@Service
public class ClientMapper {

    public Client mapClientDTOToClient(ClientInputDTO clientInputDTO) {

        Client client = new Client(clientInputDTO.getName(), clientInputDTO.getLastName());

        return client;
    }

}
