package com.jp.agrodata.jpagrodata.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TAB_PROJETO")
public class Projeto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "DESC_T255",length = 255)
    private String descricao;

    @Column(name = "NOME_PROJETO_T50", length = 50)
    private String nomeDoProjeto;

    @ManyToOne
    @JoinColumn(name = "COD_DEPARTAMENTO")
    private Departamento departamento;

    @Lob
    @Column(name = "OBJ_GERAL_TL")
    private String objetivoGeral;

    @Lob
    @Column(name = "OBJ_ESPEC_TL")
    private String objetivoEspecifico;

    @Lob
    @Column(name = "JUSTIF_TL")
    private String justificativa;

    @Lob
    @Column(name = "RESULT_ESP_TL")
    private String resultadosEsperados;

    @Lob
    @Column(name = "PARCEIROS_TL")
    private String parceiros;

    @Column(name = "DATA_INICIO_D")
    private LocalDate inicio;
    @Column(name = "DATA_FINAL_D")
    private LocalDate fim;

    @Column(name = "PUB_ALVO_T250", length = 250)
    private String publicoAlvo;

    @Column(name = "CPF_RESP_T15", length = 15)
    private String cpfResponsavel;

    @Column(name = "COD_IBGE_MUNIC_T15", length = 10)
    private String codIBGEMunicipio;

    @Column(name = "QTD_BENEF_ATD_N")
    private int numDeBeneficiarios;

    @Column(name = "VL_ORCADO_ND", nullable= false, precision=7, scale=2)    // Creates the database field with this size.
    @Digits(integer=9, fraction=2)                    // Validates data when used as a form
    private BigDecimal valorOrcado;

    @OneToMany(mappedBy = "projeto")
    List<Meta> metas;
}
