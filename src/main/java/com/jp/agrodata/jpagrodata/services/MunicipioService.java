package com.jp.agrodata.jpagrodata.services;

import com.jp.agrodata.jpagrodata.dtos.MunicipioDto;

public interface MunicipioService {
    MunicipioDto save(MunicipioDto dto);

    MunicipioDto getMunicipio(String codigo);
}
