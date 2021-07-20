package br.com.api.dto.inputs;

import br.com.api.models.Client;
import br.com.api.models.utils.Currency;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class TransferInputDTO implements Serializable {

    public static final long serialVersionUID = 1L;

    private Integer id;
    @Enumerated(EnumType.STRING)
    private Currency currency;
    private Double amount;
    private Client client;

}
