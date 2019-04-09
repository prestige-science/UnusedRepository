package com.prestige;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/user")
    public List<Users> index() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public Users show(@PathVariable String id) {
        int userId = Integer.parseInt(id);
        return userRepository.findOne(userId);
    }

    @PostMapping("/user/search")
    public List<Users> search(@RequestBody Map<String, String> body) {
        String searchTerm = body.get("text");
        return userRepository.findByEmailContainingOrCreatedContaining(searchTerm, searchTerm);
    }

    @PostMapping("/user/create")
    public Users create(@RequestBody Map<String, String> body) {
        String email    = body.get("email");
        String password = body.get("password");
        String token    = body.get("token");
        return userRepository.save(new Users(email, password, token));
    }

    @PutMapping("user/{id}")
    public Users update(@PathVariable String id, @RequestBody Map<String, String> body) {
        int userId = Integer.parseInt(id);
        Users users = userRepository.findOne(userId);
        users.setEmail(body.get("email"));
        users.setPassword(body.get("password"));
        users.setToken(body.get("token"));
        return userRepository.save(users);
    }

    @DeleteMapping("user/{id}")
    public boolean delete(@PathVariable String id) {
        int userId = Integer.parseInt(id);
        userRepository.delete(userId);
        return true;
    }
}
