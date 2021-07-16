package br.com.api.services.mapper;

import br.com.api.dto.inputs.TransferInputDTO;
import br.com.api.models.Transfer;
import org.springframework.stereotype.Service;

@Service
public class TransferMapper {

    public Transfer mapTransferDTOtoTransfer(TransferInputDTO transferInputDTO){

        Transfer transfer = new Transfer(transferInputDTO.getCurrency(), transferInputDTO.getAmount(), transferInputDTO.getClient());

        return transfer;
    }
}
