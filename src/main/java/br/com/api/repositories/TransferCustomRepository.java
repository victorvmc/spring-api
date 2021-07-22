package br.com.api.repositories;

import br.com.api.models.Transfer;
import br.com.api.models.utils.CurrencyEnum;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Repository
public interface TransferCustomRepository {

    List<Transfer> searchTransferCriteria(Integer id, Double amount, Date date, CurrencyEnum currency);
}
