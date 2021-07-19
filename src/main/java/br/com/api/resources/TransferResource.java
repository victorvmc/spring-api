package br.com.api.resources;

import br.com.api.dto.inputs.TransferInputDTO;
import br.com.api.dto.outputs.TransferOutputDTO;
import br.com.api.models.Transfer;
import br.com.api.services.implementation.TransferServiceImplementation;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@RestController
@RequestMapping("/api")
public class TransferResource {

    @Autowired
    private TransferServiceImplementation transferServiceImplementation;

    @PostMapping("/transfer")
    public ResponseEntity<TransferOutputDTO> createTransfer(@RequestBody TransferInputDTO transferInputDTO) {

        Transfer transfer = transferServiceImplementation
                .createTransfer(new Transfer(transferInputDTO.getCurrency(),transferInputDTO.getAmount(), transferInputDTO.getClient()));

        return ResponseEntity.accepted().body(new TransferOutputDTO(transfer));
    }

    @GetMapping("/transfer")
    public ResponseEntity<List<TransferOutputDTO>> readTransfer() {

        List<Transfer> transfers =  transferServiceImplementation.getTransfers();
        List<TransferOutputDTO> transfersOutputDTOList = transfers.stream().map(TransferOutputDTO::new).collect(Collectors.toList());

        return ResponseEntity.ok().body(transfersOutputDTOList);
    }

    @GetMapping("/transfer/{id}")
    public ResponseEntity<TransferOutputDTO>  readTransferById(@PathVariable("id") Integer id) {

        Transfer transferById = transferServiceImplementation.getTransferById(id);

        return ResponseEntity.ok().body(new TransferOutputDTO(transferById)) ;
    }
}
