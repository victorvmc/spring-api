package br.com.api.dto.outputs;

import br.com.api.models.Client;
import br.com.api.models.Transfer;
import br.com.api.resources.TransferResource;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
@Setter
public class ClientOutputDTO implements Serializable {

    public static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String lastName;
    private List<TransferOutputDTO> transfers;

    public ClientOutputDTO(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.lastName = client.getLastName();
        this.transfers = client.getTransfers().stream().map(TransferOutputDTO::new).collect(Collectors.toList());
    }

}
