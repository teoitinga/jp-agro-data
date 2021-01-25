package com.jp.agrodata.jpagrodata.services;

import com.jp.agrodata.jpagrodata.dtos.SituacaoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RelatorioService {
    Page<SituacaoDTO> obterSituacaoPorServico(String servico, Pageable pageRequest);
}
