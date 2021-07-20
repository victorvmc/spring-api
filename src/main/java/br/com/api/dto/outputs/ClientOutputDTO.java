package br.com.api.dto.outputs;

import br.com.api.models.Client;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class ClientOutputDTO implements Serializable {

    public static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String lastName;

    public ClientOutputDTO(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.lastName = client.getLastName();
    }

}
