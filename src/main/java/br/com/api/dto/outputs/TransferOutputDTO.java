package br.com.api.dto.outputs;

import br.com.api.models.Client;
import br.com.api.models.Transfer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class TransferOutputDTO implements Serializable {

    public static final long serialVersionUID = 1L;

    private String currency;
    private Double amount;

    public TransferOutputDTO(Transfer transfer) {

        this.currency = transfer.getCurrency();
        this.amount = transfer.getAmount();
    }
}
