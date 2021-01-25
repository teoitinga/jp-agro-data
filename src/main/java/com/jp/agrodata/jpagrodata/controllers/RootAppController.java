package com.jp.agrodata.jpagrodata.controllers;

import com.jp.agrodata.jpagrodata.dtos.*;
import com.jp.agrodata.jpagrodata.services.RelatorioService;
import com.jp.agrodata.jpagrodata.services.RootService;
import com.jp.agrodata.jpagrodata.services.impls.RelatorioServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/root")
@Slf4j
public class RootAppController {

    private RootService rootService;
    private RelatorioService relatorioService;

    public RootAppController(
            RootService rootService,
                             RelatorioService relatorioService
    ) {
        this.relatorioService = relatorioService;
        this.rootService = rootService;
    }

    @PostMapping("gerenciar-empresa")
    @ResponseStatus(HttpStatus.CREATED)
    public EmpresaDTO criaEmpresa(@RequestBody EmpresaDTO dto){
       return this.rootService.saveEmpresa(dto);

    }
    @PostMapping("root")
    @ResponseStatus(HttpStatus.CREATED)
    public RootDTO criaRoot(@RequestBody RootDTO dto){
       return this.rootService.save(dto);

    }
    @PostMapping("conta-bancaria")
    @ResponseStatus(HttpStatus.CREATED)
    public ContaBancariaDTO criaRoot(@RequestBody ContaBancariaDTO dto){
       return this.rootService.saveContaBancaria(dto);

    }
    @PostMapping("banco")
    @ResponseStatus(HttpStatus.CREATED)
    public BancoDTO criaRoot(@RequestBody BancoDTO dto){
       return this.rootService.saveBanco(dto);

    }
    @PostMapping("agencia-bancaria")
    @ResponseStatus(HttpStatus.CREATED)
    public AgenciaBancariaDTO criaRoot(@RequestBody AgenciaBancariaDTO dto){
       return this.rootService.saveAgenciaBancaria(dto);

    }
    @PostMapping("messages")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageDTO criaMensagem(@RequestBody MessageDTO dto){
       return this.rootService.saveMessage(dto);

    }
    @PostMapping("unidades")
    @ResponseStatus(HttpStatus.CREATED)
    public UnidadeDTO registraUnidadeDeMedida(@RequestBody UnidadeDTO dto){
        return this.rootService.saveUnidadeDeMedida(dto);
    }
    @PostMapping("contrato")
    @ResponseStatus(HttpStatus.CREATED)
    public ContratoDTO criaContrato(@RequestBody ContratoDTO dto){
        return this.rootService.criaContrato(dto);
    }

    @PostMapping("system")
    @ResponseStatus(HttpStatus.CREATED)
    public AppDTO criaLicenca(@RequestBody AppDTO dto){
        return this.rootService.criaApp(dto);
    }

    @PostMapping("situacao")
    @ResponseStatus(HttpStatus.CREATED)
    public SituacaoDTO criaSituacao(@RequestBody SituacaoDTO dto){
        return this.rootService.criaSituacao(dto);

    }
    @PostMapping("orientacao")
    @ResponseStatus(HttpStatus.CREATED)
    public OrientacaoDTO criaOrientacao(@RequestBody OrientacaoDTO dto){

        return this.rootService.criaOrientacao(dto);
    }
    @PostMapping("recomendacao")
    @ResponseStatus(HttpStatus.CREATED)
    public RecomendacaoDTO criaRecomendacao(@RequestBody RecomendacaoDTO dto){
        return this.rootService.criaRecomendacao(dto);
    }
    @GetMapping("situacao/{servico}")
    @ResponseStatus(HttpStatus.OK)
    public Page<SituacaoDTO> obterSituacaoPorServico(@PathVariable String servico, Pageable pageRequest){
        return this.relatorioService.obterSituacaoPorServico(servico, pageRequest);
    }
}
