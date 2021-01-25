package com.jp.agrodata.jpagrodata.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.jp.agrodata.jpagrodata.models.entities.Cargo;
import com.jp.agrodata.jpagrodata.models.entities.Contrato;
import com.jp.agrodata.jpagrodata.models.entities.Message;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaDTO implements Serializable {

    private Integer id;

    private String cnpj;

    private String nomeFantasia;

    private String endereco;

    private String contatoEmpresa;

    private String emailEmpresa;

    private String nomeRepresentante;

    private String contatoRepresentante;

    private String cpfRepresentante;

    private String emailRepresentante;

    private String codIBGEMunicipio;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> messages;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String contrato;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> cargos;
}
