package com.jp.agrodata.jpagrodata.services;

import com.jp.agrodata.jpagrodata.dtos.UnidadeDto;

public interface UnidadeService {
    UnidadeDto save(UnidadeDto dto);

    UnidadeDto getById(String id);
}
