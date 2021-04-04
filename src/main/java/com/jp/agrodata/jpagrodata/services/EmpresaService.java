package com.jp.agrodata.jpagrodata.services;

import com.jp.agrodata.jpagrodata.dtos.EmpresaDTO;

public interface EmpresaService {
    EmpresaDTO save(EmpresaDTO any);

    EmpresaDTO obterEmpresa(Integer id);

    EmpresaDTO update(EmpresaDTO dto, String id);
}
