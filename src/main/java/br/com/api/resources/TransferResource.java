package br.com.api.resources;

import br.com.api.models.Transfer;
import br.com.api.repositories.TransferRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@RestController
@RequestMapping("/api")
public class TransferResource {

    @Autowired
    private TransferRepository transferRepository;

    @PostMapping("/transfer")
    public Transfer createTransfer(@RequestBody Transfer transfer) {
        return transferRepository.save(transfer);
    }

    @GetMapping("/transfer")
    public List<Transfer> readTransfer() {
        return transferRepository.findAll();
    }

    @GetMapping("/transfer/{id}")
    public Transfer readTransfer(@PathVariable("id") Integer id) {

        Optional<Transfer> transfer = transferRepository.findById(id);

        return transfer.orElse(null);
    }

    @PutMapping("/transfer")
    public Transfer updateTransfer(@RequestBody Transfer transfer) {
        return transferRepository.save(transfer);
    }

    @DeleteMapping("/transfer/{id}")
    public void deleteTransfer(@PathVariable("id") Integer id) {
        transferRepository.deleteById(id);
    }

}
