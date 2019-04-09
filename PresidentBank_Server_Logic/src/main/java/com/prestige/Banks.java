package com.prestige;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Banks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int code;
    private int id_address;
    private String created;
    private String updated;

    public Banks() {}
    public Banks(int code, int id_address) {
        this.setCode(code);
        this.setIdAddress(id_address);
    }
    public Banks(int id, int code, int id_address, String created, String updated) {
        this.setId(id);
        this.setCode(code);
        this.setIdAddress(id_address);
        this.setCreated(created);
        this.setUpdated(updated);
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public void setIdAddress(int id_address) {
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
    public int getCode() {
        return code;
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
        return "Banks{" +
                "id=" + id +
                ", code=" + code +
                ", id_address=" + id_address + '\'' +
                ", created='" + created + '\'' +
                ", updated='" + updated + '\'' +
                "}";
    }
}
