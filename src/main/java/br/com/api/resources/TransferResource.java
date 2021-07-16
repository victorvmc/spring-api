package br.com.api.resources;

import br.com.api.dto.inputs.TransferInputDTO;
import br.com.api.models.Transfer;
import br.com.api.services.implementation.TransferServiceImplementation;
import br.com.api.services.mapper.TransferMapper;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@NoArgsConstructor
@RestController
@RequestMapping("/api")
public class TransferResource {

    @Autowired
    private TransferServiceImplementation transferServiceImplementation;

    @Autowired
    private TransferMapper transferMapper;

    @PostMapping("/transfer")
    public ResponseEntity<Transfer> createTransfer(@RequestBody TransferInputDTO transferInputDTO) {

        Transfer transfer = transferServiceImplementation.createTransfer(transferMapper.mapTransferDTOtoTransfer(transferInputDTO));

        return ResponseEntity.accepted().body(transferServiceImplementation.createTransfer(transfer));
    }

    @GetMapping("/transfer")
    public ResponseEntity<List<Transfer>> readTransfer() {

        List<Transfer> transfers =  transferServiceImplementation.getTransfers();

        return ResponseEntity.ok().body(transferServiceImplementation.getTransfers());
    }

//    @GetMapping("/transfer/{id}")
//    public Transfer readTransfer(@PathVariable("id") Integer id) {
//
//        Optional<Transfer> transfer = transferRepository.findById(id);
//
//        return transfer.orElse(null);
//    }
}
