package com.prestige;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int id_user;
    private String name;
    private String dateOfBirth;
    private String cardNumber;
    private String pin;
    private int id_address;
    private String created;
    private String updated;

    public Customers() {}
    public Customers(int id_user, String name, String dateOfBirth, String cardNumber, String pin, int id_address) {
        this.setIdUser(id_user);
        this.setName(name);
        this.setDateOfBirth(dateOfBirth);
        this.setCardNumber(cardNumber);
        this.setPin(pin);
        this.setIdAddress(id_address);
    }
    public Customers(int id, int id_user, String name, String dateOfBirth, String cardNumber, String pin, int id_address, String created, String updated) {
        this.setId(id);
        this.setIdUser(id_user);
        this.setName(name);
        this.setDateOfBirth(dateOfBirth);
        this.setCardNumber(cardNumber);
        this.setPin(pin);
        this.setIdAddress(id_address);
        this.setCreated(created);
        this.setUpdated(updated);
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setIdUser(int id_user) {
        this.id_user = id_user;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public void setPin(String pin) {
        this.pin = pin;
    }
    public void setIdAddress(int idAddress) {
        this.id_address = id_address;
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
    public int getIdUser() {
        return id_user;
    }
    public String getName() {
        return name;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public String getCardNumber() {
        return cardNumber;
    }
    public String getPin() {
        return pin;
    }
    public int getIdAddress() {
        return id_address;
    }
    public String getCreated() {
        return created;
    }
    public String getUpdated() {
        return updated;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "id=" + id +
                ", id_user=" + id_user +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", pin='" + pin + '\'' +
                ", id_address=" + id_address +
                ", created='" + created + '\'' +
                ", updated='" + updated + '\'' +
                "}";
    }
}
