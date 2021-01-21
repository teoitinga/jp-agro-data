package com.jp.agrodata.jpagrodata.models.entities;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@Entity
public class Projeto implements Serializable {
    @Id
    private Integer id;

    @Column(columnDefinition = "mediumtext")
    private String descricao;

    private String nomeDoProjeto;
    private String codDepartamento;
    @Column(columnDefinition = "mediumtext")
    private String objetivoGeral;
    @Column(columnDefinition = "mediumtext")
    private String objetivoEspecifico;
    @Column(columnDefinition = "mediumtext")
    private String justificativa;
    @Column(columnDefinition = "mediumtext")
    private String resultadosEsperados;
    @Column(columnDefinition = "mediumtext")
    private String parceiros;
    private LocalDate inicio;
    private LocalDate fim;
    @Column(columnDefinition = "mediumtext")
    private String publicoAlvo;

    private String cpfResponsavel;
    private String codIBGEMunicipio;
    private int numDeBeneficiarios;

    @Column(nullable= false, precision=7, scale=2)    // Creates the database field with this size.
    @Digits(integer=9, fraction=2)                    // Validates data when used as a form
    private BigDecimal valorOrcado;
}
