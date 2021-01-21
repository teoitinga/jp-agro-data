package com.jp.agrodata.jpagrodata.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String nome;
    protected String email;
    protected String endereco;
    protected String whatsapp;
    protected String foneContato;

    private LocalDateTime lastUpdated;
    private String lastUpdateUser;
    private String lastUpdateEmpresa;
    private LocalDateTime created;
    private String createUser;
    private String creatempresa;

    @PreUpdate
    public void preUpdate(){
        this.lastUpdateUser = "JP";
        this.lastUpdateEmpresa = "ESLOC";
        this.lastUpdated = LocalDateTime.now();
    }

    @PrePersist
    public void prePersist(){
        this.createUser = "JP";
        this.creatempresa = "ESLOC";
        this.created = LocalDateTime.now();
    }
}
