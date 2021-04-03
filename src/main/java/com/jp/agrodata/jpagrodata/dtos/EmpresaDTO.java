package com.jp.agrodata.jpagrodata.dtos;

import com.jp.agrodata.jpagrodata.models.entities.Cargo;
import com.jp.agrodata.jpagrodata.models.entities.Contrato;
import com.jp.agrodata.jpagrodata.models.entities.Setor;
import com.jp.agrodata.jpagrodata.models.entities.Usuario;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class EmpresaDTO implements Serializable {

    private Integer id;

    @CNPJ(message = "Você deve informar um CNPJ válido")
    private String cnpj;

    @NotEmpty(message = "Você deve informar o nome fantasia da empresa")
    private String nomeFantasia;

    private String endereco;

    private String contatoEmpresa;

    private String emailEmpresa;

    private UsuarioDto representante;

    private String codContrato;
}
