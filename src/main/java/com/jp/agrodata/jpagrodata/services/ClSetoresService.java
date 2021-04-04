package com.jp.agrodata.jpagrodata.services;

import com.jp.agrodata.jpagrodata.dtos.SetorClassDto;

public interface ClSetoresService {
    SetorClassDto save(SetorClassDto dto);

    SetorClassDto getById(String id);
}
