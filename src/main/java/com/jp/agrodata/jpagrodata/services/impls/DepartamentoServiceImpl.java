package com.jp.agrodata.jpagrodata.services.impls;

import com.jp.agrodata.jpagrodata.dtos.DepartamentoDTO;
import com.jp.agrodata.jpagrodata.services.DepartamentoService;
import org.springframework.stereotype.Service;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {
    @Override
    public DepartamentoDTO save(DepartamentoDTO dto) {
        return dto;
    }
}
