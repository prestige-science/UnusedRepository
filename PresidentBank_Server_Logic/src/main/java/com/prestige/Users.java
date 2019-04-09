package com.prestige;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String email;
    private String password;
    private String token;
    private String created;
    private String updated;

    public Users() {}
    public Users(String email, String password, String token) {
        this.setEmail(email);
        this.setPassword(password);
        this.setToken(token);
    }
    public Users(int id, String email, String password, String token, String created, String updated) {
        this.setId(id);
        this.setEmail(email);
        this.setPassword(password);
        this.setToken(token);
        this.setCreated(created);
        this.setUpdated(updated);
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public void setCreated(String created) {
        this.created = created;
    }
    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public int getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getToken() {
        return token;
    }
    public String getCreated() {
        return created;
    }
    public String getUpdated() {
        return updated;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", token='" + token + '\'' +
                ", created='" + created + '\'' +
                ", updated='" + updated + '\'' +
                "}";
    }
}
