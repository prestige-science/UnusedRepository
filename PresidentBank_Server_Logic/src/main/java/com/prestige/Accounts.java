package com.prestige;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int id_user;
    private int id_bank;
    private double amount;
    private String type;
    private String created;

    public Accounts() {}
    public Accounts(int id_user, int id_bank, double amount, String type) {
        this.setIdUser(id_user);
        this.setIdBank(id_bank);
        this.setAmount(amount);
        this.setType(type);
    }
    public Accounts(int id, int id_user, int id_bank, double amount, String type, String created) {
        this.setId(id);
        this.setIdUser(id_user);
        this.setIdBank(id_bank);
        this.setAmount(amount);
        this.setType(type);
        this.setCreated(created);
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setIdUser(int id_user) {
        this.id_user = id_user;
    }
    public void setIdBank(int id_bank) {
        this.id_bank = id_bank;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setCreated(String created) {
        this.created = created;
    }

    public int getId(int id) {
        return id;
    }
    public int getIdUser() {
        return id_user;
    }
    public int getIdBank() {
        return id_bank;
    }
    public double getAmount() {
        return amount;
    }
    public String getType() {
        return type;
    }
    public String getCreated() {
        return created;
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "id=" + id +
                ", id_user=" + id_user +
                ", id_bank=" + id_bank +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                ", created='" + created + '\'' +
                '}';
    }
}