package br.com.api.services;

import br.com.api.models.Transfer;

import java.util.List;

public interface TransferService {

    public Transfer createTransfer(Transfer transfer);

    public List<Transfer> getTransfers();

    public Transfer getTransferById(Integer id);

}
