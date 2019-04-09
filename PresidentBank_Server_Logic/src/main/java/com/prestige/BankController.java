package com.prestige;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class BankController {
    @Autowired
    BankRepository bankRepository;

    @GetMapping("/bank")
    public List<Banks> index() {
        return bankRepository.findAll();
    }

    @GetMapping("/bank/{id}")
    public Banks show(@PathVariable String id) {
        int bankId = Integer.parseInt(id);
        return bankRepository.findOne(bankId);
    }

    @PostMapping("/bank/search")
    public List<Banks> search(@RequestBody Map<String, String> body) {
        String searchTerm = body.get("text");
        return bankRepository.findByCodeContaining(searchTerm);
    }

    @PostMapping("/bank/create")
    public Banks create(@RequestBody Map<String, String> body) {
        int code = Integer.parseInt(body.get("code"));
        int id_address = Integer.parseInt(body.get("id_address"));
        return bankRepository.save(new Banks(code, id_address));
    }

    @PutMapping("/bank/{id}")
    public Banks update(@PathVariable String id, @RequestBody Map<String, String> body) {
        int bankId = Integer.parseInt(id);
        Banks banks = bankRepository.findOne(bankId);
        banks.setCode(Integer.parseInt(body.get("code")));
        banks.setIdAddress(Integer.parseInt(body.get("id_address")));
        return bankRepository.save(banks);
    }

    @DeleteMapping("/bank/{id}")
    public boolean delete(@PathVariable String id) {
        int bankId = Integer.parseInt(id);
        bankRepository.delete(bankId);
        return true;
    }
}
