package com.jp.agrodata.jpagrodata.services.impls;

import com.jp.agrodata.jpagrodata.configs.Configuration;
import com.jp.agrodata.jpagrodata.dtos.ProjetoDTO;
import com.jp.agrodata.jpagrodata.models.entities.Projeto;
import com.jp.agrodata.jpagrodata.services.ProjetoService;
import org.springframework.stereotype.Service;

@Service
public class ProjetoServiceImpl implements ProjetoService {

    private Configuration config;

    public ProjetoServiceImpl(Configuration config) {
        this.config = config;
    }

    @Override
    public ProjetoDTO save(ProjetoDTO dto) {
        Projeto projeto = toProjeto(dto);
        return dto;
    }

    private Projeto toProjeto(ProjetoDTO dto) {
        return null;
    }
}
