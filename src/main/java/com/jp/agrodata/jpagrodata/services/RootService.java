package com.jp.agrodata.jpagrodata.services;

import com.jp.agrodata.jpagrodata.dtos.*;

public interface RootService {
    RootDTO save(RootDTO dto);

    ContaBancariaDTO saveContaBancaria(ContaBancariaDTO contaBancariaDTO);

    BancoDTO saveBanco(BancoDTO dto);

    AgenciaBancariaDTO saveAgenciaBancaria(AgenciaBancariaDTO dto);

    MessageDTO saveMessage(MessageDTO dto);

    EmpresaDTO saveEmpresa(EmpresaDTO dto);

    UnidadeDTO saveUnidadeDeMedida(UnidadeDTO dto);

    ContratoDTO criaContrato(ContratoDTO dto);

    AppDTO criaApp(AppDTO dto);

    SituacaoDTO criaSituacao(SituacaoDTO dto);

    OrientacaoDTO criaOrientacao(OrientacaoDTO dto);

    RecomendacaoDTO criaRecomendacao(RecomendacaoDTO dto);
}
