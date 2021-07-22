package br.com.api.dto.outputs;

import br.com.api.models.Client;
import br.com.api.models.Transfer;
import br.com.api.models.utils.CurrencyEnum;
import br.com.api.services.ClientService;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Transient;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class TransferOutputDTO implements Serializable {

    public static final long serialVersionUID = 1L;

    @Enumerated(EnumType.STRING)
    private CurrencyEnum currency;
    private Double amount;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date date;

    public TransferOutputDTO(Transfer transfer) {
        this.currency = transfer.getCurrency();
        this.amount = transfer.getAmount();
        this.date = transfer.getDate();
    }
}
