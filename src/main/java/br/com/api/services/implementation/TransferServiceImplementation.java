package br.com.api.services.implementation;

import br.com.api.models.Transfer;
import br.com.api.repositories.TransferRepository;
import br.com.api.services.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferServiceImplementation implements TransferService {

    @Autowired
    private TransferRepository transferRepository;

    @Override
    public Transfer createTransfer(Transfer transfer) {
        return transferRepository.save(transfer);
    }

    @Override
    public List<Transfer> getTransfers() {

        return transferRepository.findAll();
    }
}
