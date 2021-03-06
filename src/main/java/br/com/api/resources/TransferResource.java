package br.com.api.resources;

import br.com.api.dto.inputs.TransferInputDTO;
import br.com.api.dto.outputs.TransferOutputDTO;
import br.com.api.models.Client;
import br.com.api.models.Transfer;
import br.com.api.models.utils.CurrencyEnum;
import br.com.api.repositories.TransferCustomRepositoryImpl;
import br.com.api.services.ClientService;
import br.com.api.services.TransferService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@RestController
@RequestMapping("transfer")
public class TransferResource {

    @Autowired
    private TransferService transferService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private TransferCustomRepositoryImpl transferCustomRepositoryImpl;

    @PostMapping("")
    public ResponseEntity<TransferOutputDTO> createTransfer(@RequestBody TransferInputDTO transferInputDTO) {

        Transfer transfer = transferService
                .createTransfer(new Transfer(transferInputDTO.getCurrency(), transferInputDTO.getAmount(), transferInputDTO.getClient()));

        return new ResponseEntity<>(new TransferOutputDTO(transfer), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<TransferOutputDTO>> readTransfer() {

        List<Transfer> transfers = transferService.getTransfers();

        return new ResponseEntity<>(transfers.stream().map(TransferOutputDTO::new).collect(Collectors.toList()), HttpStatus.ACCEPTED);
    }

    @GetMapping("search")
    public ResponseEntity<List<TransferOutputDTO>> readTransferByCriteria(
            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam(value = "amount", required = false) Double amount,
            @RequestParam(value = "date", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
            @RequestParam(value = "currency", required = false) CurrencyEnum currency) {

        List<Transfer> transferList = transferService.getTransferCriteria(id, amount, date, currency);

        return new ResponseEntity<>(transferList.stream().map(TransferOutputDTO::new).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("search/id/{id}")
    public ResponseEntity<TransferOutputDTO> readTransferById(@PathVariable("id") Integer id) {

        Transfer transferById = transferService.getTransferById(id);

        if (transferById != null)
            return new ResponseEntity<>(new TransferOutputDTO(transferById), HttpStatus.ACCEPTED);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("search/clientId/{id}")
    public ResponseEntity<List<TransferOutputDTO>> readTransferByClientId(@PathVariable("id") Integer id) {

        Client clientById = clientService.getClientById(id);
        List<Transfer> transferListByClientId = transferService.getTransferByClient(clientById);

        return new ResponseEntity<>(transferListByClientId.stream().map(TransferOutputDTO::new).collect(Collectors.toList()), HttpStatus.ACCEPTED);
    }

    @GetMapping("search/clientName/{name}")
    public ResponseEntity<List<TransferOutputDTO>> readTransferByClientName(@PathVariable("name") String name) {

        Client clientByName = clientService.getClientByName(name);
        List<Transfer> transferListByClientName = transferService.getTransferByClient(clientByName);

        return new ResponseEntity<>(transferListByClientName.stream().map(TransferOutputDTO::new).collect(Collectors.toList()), HttpStatus.ACCEPTED);
    }

    @GetMapping("search/date/{date}")
    public ResponseEntity<List<TransferOutputDTO>> readTransferByDate(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {

        List<Transfer> transferList = transferService.getTransferByDate(date);

        return new ResponseEntity<>(transferList.stream().map(TransferOutputDTO::new).collect(Collectors.toList()), HttpStatus.ACCEPTED);
    }

    @GetMapping("query")
    public ResponseEntity<List<TransferOutputDTO>>  readTransferByQuery(
            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam(value = "amount", required = false) Double amount,
            @RequestParam(value = "date", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
            @RequestParam(value = "currency", required = false) CurrencyEnum currency) {

        List<Transfer> transferList = transferService.getTransferCustom(id, amount, date, currency);

        return new ResponseEntity<>(transferList.stream().map(TransferOutputDTO::new).collect(Collectors.toList()), HttpStatus.OK);
    }
}
