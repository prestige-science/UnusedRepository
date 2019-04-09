package com.prestige;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class AccountController {
    @Autowired
    AccountRespository accountRespository;

    @GetMapping("/account")
    public List<Accounts> index() {
        return accountRespository.findAll();
    }

    @GetMapping("/account/{id}")
    public Accounts show(@PathVariable String id) {
        int accountId = Integer.parseInt(id);
        return accountRespository.findOne(accountId);
    }

    @PostMapping("/account/search")
    public List<Accounts> search(@RequestBody Map<String, String> body) {
        String searchTerm = body.get("text");
        return accountRespository.findByAmountContainingOrTypeContaining(searchTerm, searchTerm);
    }

    @PostMapping("/account")
    public Accounts create(@RequestBody Map<String, String> body) {
        int id_user     = Integer.parseInt(body.get("id_user"));
        int id_bank     = Integer.parseInt(body.get("id_bank"));
        double amount   = Double.parseDouble(body.get("amount"));
        String type     = body.get("type");
        return accountRespository.save(new Accounts(id_user, id_bank, amount, type));
    }

    @PutMapping("/account/{id}")
    public Accounts update(@PathVariable String id, @RequestBody Map<String, String> body) {
        int accountId = Integer.parseInt(id);
        Accounts account = accountRespository.findOne(accountId);
        account.setAmount(Double.parseDouble(body.get("amount")));
        account.setType(body.get("type"));
        return accountRespository.save(account);
    }

    @DeleteMapping("/account/{id}")
    public boolean delete(@PathVariable String id) {
        int accountId = Integer.parseInt(id);
        accountRespository.delete(accountId);
        return true;
    }
}