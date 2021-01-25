package com.jp.agrodata.jpagrodata.services;

import com.jp.agrodata.jpagrodata.dtos.*;
import com.jp.agrodata.jpagrodata.models.entities.Departamento;
import com.jp.agrodata.jpagrodata.models.entities.Empresa;

public interface DepartamentoService {
    //DepartamentoDTO save(DepartamentoDTO dto);

    DepartamentoDTO toDepartamentoDTO(Departamento departamento);

    Departamento toDepartamento(DepartamentoDTO dto, Empresa empresaInfo);

    ProjetoDTO criaProjeto(ProjetoDTO dto);

    Departamento saveDepartamento(Departamento departamento);

    MetaPostDTO criaMeta(MetaPostDTO dto);

    ServicoPostDTO registraServico(ServicoPostDTO dto);
}
