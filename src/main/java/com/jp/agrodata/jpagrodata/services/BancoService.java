package com.jp.agrodata.jpagrodata.services;

import com.jp.agrodata.jpagrodata.dtos.AgenciaBancariaDto;
import com.jp.agrodata.jpagrodata.dtos.BancoDto;
import com.jp.agrodata.jpagrodata.dtos.ContaBancariaDto;

public interface BancoService {
    AgenciaBancariaDto saveAgencia(AgenciaBancariaDto any);

    AgenciaBancariaDto getAgencia(String id);

    BancoDto saveBanco(BancoDto dto);

    BancoDto getBanco(String id);

    ContaBancariaDto saveConta(ContaBancariaDto any);

    ContaBancariaDto getConta(String id);
}
