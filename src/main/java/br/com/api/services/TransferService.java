package br.com.api.services;

import br.com.api.models.Client;
import br.com.api.models.Transfer;
import br.com.api.repositories.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransferService {

    @Autowired
    private TransferRepository transferRepository;

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
}
