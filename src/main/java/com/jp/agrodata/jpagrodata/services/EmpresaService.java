package com.jp.agrodata.jpagrodata.services;

import com.jp.agrodata.jpagrodata.dtos.EmpresaDTO;
import com.jp.agrodata.jpagrodata.models.entities.Empresa;

public interface EmpresaService {
    EmpresaDTO save(EmpresaDTO dto);

    Empresa toEmpresa(EmpresaDTO dto);

    EmpresaDTO toEmpresaDTO(Empresa empresa);

}
