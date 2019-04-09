package com.prestige;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class TransactionController {
    @Autowired
    TransactionRepository transactionRepository;

    @GetMapping("/transaction")
    public List<Transactions> index() {
        return transactionRepository.findAll();
    }

    @GetMapping("/transaction/{id}")
    public Transactions show(@PathVariable String id) {
        int transactionId = Integer.parseInt(id);
        return transactionRepository.findOne(transactionId);
    }

    @PostMapping("/transaction/search")
    public List<Transactions> search(@RequestBody Map<String, String> body) {
        String searchTerm = body.get("text");
        return transactionRepository.findBySerialContainingOrCreatedContaining(searchTerm, searchTerm);
    }

    @PostMapping("/transaction/create")
    public Transactions create(@RequestBody Map<String, String> body) {
        int id_account      = Integer.parseInt(body.get("id_account"));
        int id_reference    = Integer.parseInt(body.get("id_reference"));
        int code            = Integer.parseInt(body.get("code"));
        String serial       = body.get("serial");
        return transactionRepository.save(new Transactions(id_account, id_reference, code, serial));
    }

    @PutMapping("/transaction/{id}")
    public Transactions update(@PathVariable String id ,@RequestBody Map<String, String> body) {
        int transactionId = Integer.parseInt(id);
        Transactions transactions = transactionRepository.findOne(transactionId);
        transactions.setIdReference(Integer.parseInt(body.get("id_reference")));
        transactions.setCode(Integer.parseInt(body.get("code")));
        transactions.setSerial(body.get("serial"));
        return transactionRepository.save(transactions);
    }

    @DeleteMapping("/transaction/{id}")
    public boolean delete(@PathVariable String id) {
        int transactionId = Integer.parseInt(id);
        transactionRepository.delete(transactionId);
        return true;
    }
}
