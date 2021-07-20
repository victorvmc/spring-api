package br.com.api.dto.outputs;

import br.com.api.models.Transfer;
import br.com.api.models.utils.Currency;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class TransferOutputDTO implements Serializable {

    public static final long serialVersionUID = 1L;
    @Enumerated(EnumType.STRING)
    private Currency currency;
    private Double amount;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime created_at;

    public TransferOutputDTO(Transfer transfer) {
        this.currency = transfer.getCurrency();
        this.amount = transfer.getAmount();
        this.created_at = transfer.getCreated_at();
    }
}
