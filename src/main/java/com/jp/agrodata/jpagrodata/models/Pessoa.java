package com.jp.agrodata.jpagrodata.models;

import com.jp.agrodata.jpagrodata.models.entities.Usuario;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "REGIME_JURIDICO")
@Table(name = "TAB_PESSOAL")
public abstract class Pessoa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", nullable=true, unique = true)
    private Long id;

    @Column(name="NOME_T100", length = 100, nullable=true, unique = false)
    private String nome;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "email", column = @Column(name = "EMAIL_T50")),
            @AttributeOverride( name = "endereco", column = @Column(name = "ENDERECO_T100")),
            @AttributeOverride( name = "whatsapp", column = @Column(name = "ZAP_T12")),
            @AttributeOverride( name = "foneContato", column = @Column(name = "FONE_T12")),
            @AttributeOverride( name = "municipio", column = @Column(name = "MUNICIPIO_T30"))
    })
    private Contato contato;

    @Column(name="LAST_UPDATED")
    private LocalDateTime lastUpdated;

    @Column(name="LAST_UPDATE_USER")
    private Usuario lastUpdateUser;

    @Column(name="CREATED")
    private LocalDateTime created;

    @ManyToOne
    @JoinColumn(name = "USUARIO_ID")
    private Usuario createUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    @PreUpdate
    public void preUpdate(){
        this.lastUpdateUser = null;
        this.lastUpdated = LocalDateTime.now();
    }

    @PrePersist
    public void prePersist(){
        this.createUser = null;
        this.created = LocalDateTime.now();
    }
}
