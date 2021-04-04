package com.jp.agrodata.jpagrodata.services;

import com.jp.agrodata.jpagrodata.dtos.ClausulaDto;
import com.jp.agrodata.jpagrodata.dtos.ContratoDto;
import com.jp.agrodata.jpagrodata.dtos.PlanoDto;

public interface ContratoService {
    ContratoDto save(ContratoDto dto);

    PlanoDto savePlano(PlanoDto dto);

    ClausulaDto saveClausula(ClausulaDto dto);

    ContratoDto getContrato(Integer id);

    PlanoDto getPlano(Integer id);

    ClausulaDto getClausula(Integer any);
}
