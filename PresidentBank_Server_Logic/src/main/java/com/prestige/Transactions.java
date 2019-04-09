package com.prestige;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int id_account;
    private int id_reference;
    private int code;
    private String serial;
    private String created;

    public Transactions() {}
    public Transactions(int id_account, int id_reference, int code, String serial) {
        this.setIdAccount(id_account);
        this.setIdReference(id_reference);
        this.setCode(code);
        this.setSerial(serial);
    }
    public Transactions(int id, int id_account, int id_reference, int code, String serial, String created) {
        this.setId(id);
        this.setIdAccount(id_account);
        this.setIdReference(id_reference);
        this.setCode(code);
        this.setSerial(serial);
        this.setCreated(created);
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setIdAccount(int id_account) {
        this.id_account = id_account;
    }
    public void setIdReference(int id_reference) {
        this.id_reference = id_reference;
    };
    public void setCode(int code) {
        this.code = code;
    }
    public void setSerial(String serial) {
        this.serial = serial;
    }
    public void setCreated(String created) {
        this.created = created;
    }

    public int getId() {
        return id;
    }
    public int getIdAccount() {
        return id_account;
    }
    public int getIdReference() {
        return id_reference;
    }
    public int getCode() {
        return code;
    }
    public String getSerial() {
        return serial;
    }
    public String getCreated() {
        return created;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "id=" + id +
                ", id_account=" + id_account +
                ", code=" + code +
                ", serial='" + serial + '\'' +
                ", created='" + created + '\'' +
                '}';
    }
}
