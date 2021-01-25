package com.jp.agrodata.jpagrodata.dtos;

import com.jp.agrodata.jpagrodata.models.entities.Departamento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjetoPostDTO  implements Serializable {

    private String descricao;

    private String nomeDoProjeto;

    private Departamento departamento;

    private String objetivoGeral;

    private String objetivoEspecifico;

    private String justificativa;

    private String resultadosEsperados;

    private String parceiros;

    private LocalDate inicio;

    private LocalDate fim;

    private String publicoAlvo;

    private String cpfResponsavel;

    private String codIBGEMunicipio;

    private int numDeBeneficiarios;

    private BigDecimal valorOrcado;

    List<MetaPostDTO> metas;
}
