package br.com.api.services;

import br.com.api.models.Client;
import br.com.api.models.Transfer;
import br.com.api.models.utils.CurrencyEnum;
import br.com.api.repositories.TransferCustomRepositoryImpl;
import br.com.api.repositories.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TransferService {

    @Autowired
    private TransferRepository transferRepository;

    @Autowired
    private TransferCustomRepositoryImpl transferCustomRepositoryImpl;

    public Transfer createTransfer(Transfer transfer) {
        return transferRepository.save(transfer);
    }

    public List<Transfer> getTransfers() {
        return transferRepository.findAll();
    }

    public Transfer getTransferById(Integer id) {
        Optional<Transfer> transfer = transferRepository.findById(id);
        return transfer.orElse(null);
    }

    public List<Transfer> getTransferByClient(Client client) {
        return transferRepository.findByClient(client);
    }

    public List<Transfer> getTransferByDate(Date date) {
        return transferRepository.findAllByDate(date);
    }

    public List<Transfer> getTransferCustom(Integer id, Double amount, Date date, CurrencyEnum currency) {

        return transferCustomRepositoryImpl.searchTransferManual(id, amount, date, currency);
    }

    public List<Transfer> getTransferCriteria(Integer id, Double amount, Date date, CurrencyEnum currency) {

        return transferCustomRepositoryImpl.searchTransferCriteria(id, amount, date, currency);
    }
}
