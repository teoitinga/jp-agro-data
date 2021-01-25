package com.jp.agrodata.jpagrodata.services;

import com.jp.agrodata.jpagrodata.dtos.CargoDTO;
import com.jp.agrodata.jpagrodata.dtos.DepartamentoDTO;
import com.jp.agrodata.jpagrodata.dtos.EmpresaDTO;
import com.jp.agrodata.jpagrodata.models.entities.Empresa;

public interface EmpresaService {
    EmpresaDTO save(EmpresaDTO dto);

    Empresa toEmpresa(EmpresaDTO dto);

    EmpresaDTO toEmpresaDTO(Empresa empresa);

    Empresa findById(Integer codEmpresa);

    DepartamentoDTO saveDepartamento(DepartamentoDTO dto);

    CargoDTO saveCargo(CargoDTO dto);

    Empresa findByCnpj(String cnpj);
}
