package br.com.api.dto.inputs;

import br.com.api.models.Client;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class ClientInputDTO implements Serializable {

    public static final long serialVersionUID = 1L;

    @Autowired
    private Client client;

    private Integer id;
    private String name;
    private String lastName;

    public ClientInputDTO(ClientInputDTO clientInputDTO) {
        client.setName(clientInputDTO.name);
        client.setLastName(clientInputDTO.lastName);
    }
}
