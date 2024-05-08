package com.reportsMicroservice.demo.model.others;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Integer clientId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    public Client(Integer clientId, String clientA, String mail, String number, String s) {
        this.clientId = clientId;
        this.name = clientA;
        this.email = mail;
        this.phoneNumber = number;
        this.address = s;

    }

    // Getters and setters (omitted for brevity)

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
