package com.prestige;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/customer")
    public List<Customers> index() {
        return customerRepository.findAll();
    }

    @GetMapping("/customer/{id}")
    public Customers show(@PathVariable String id) {
        int customerId = Integer.parseInt(id);
        return customerRepository.findOne(customerId);
    }

    @PostMapping("/customer/search")
    public List<Customers> search(@RequestBody Map<String, String> body) {
        String searchTerm = body.get("text");
        return customerRepository.findByNameContaining(searchTerm);
    }

    @PostMapping("/customer/create")
    public Customers create(@RequestBody Map<String, String> body) {
        int id_user = Integer.parseInt(body.get("id_user"));
        String name = body.get("name");
        String dateOfBirth = body.get("dateOfBirth");
        String cardNumber = body.get("cardNumber");
        String pin = body.get("pin");
        int id_address = Integer.parseInt(body.get("id_address"));
        return customerRepository.save(new Customers(id_user, name, dateOfBirth, cardNumber, pin, id_address));
    }

    @PutMapping("/customer/{id}")
    public Customers update(@PathVariable String id, @RequestBody Map<String, String> body) {
        int customerId = Integer.parseInt(id);
        Customers customers = customerRepository.findOne(customerId);
        customers.setIdUser(Integer.parseInt(body.get("id_user")));
        customers.setName(body.get("name"));
        customers.setDateOfBirth(body.get("dateOfBirth"));
        customers.setCardNumber(body.get("cardNumber"));
        customers.setPin(body.get("pin"));
        customers.setIdAddress(Integer.parseInt(body.get("id_address")));
        return customerRepository.save(customers);
    }

    @DeleteMapping("/customer/{id}")
    public boolean delete(@PathVariable String id) {
        int customerId = Integer.parseInt(id);
        customerRepository.delete(customerId);
        return true;
    }
}
