package com.jp.agrodata.jpagrodata.controllers;

import com.jp.agrodata.jpagrodata.dtos.*;
import com.jp.agrodata.jpagrodata.services.BeneficiarioService;
import com.jp.agrodata.jpagrodata.services.DepartamentoService;
import com.jp.agrodata.jpagrodata.services.ProjetoService;
import com.jp.agrodata.jpagrodata.services.impls.BeneficiarioServiceImpl;
import com.jp.agrodata.jpagrodata.services.impls.DepartamentoServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/departamento")
@Slf4j
public class DepartamentoController {

    private DepartamentoService departamentoService;
    private BeneficiarioService beneficiarioService;

    public DepartamentoController(DepartamentoService departamentoService,
                                  BeneficiarioServiceImpl beneficiarioService
    ) {
        this.departamentoService = departamentoService;
        this.beneficiarioService = beneficiarioService;
    }

    @PostMapping("gerenciar-projeto")
    @ResponseStatus(HttpStatus.CREATED)
    public ProjetoDTO criaCriaProjeto(@RequestBody ProjetoDTO dto){

        ProjetoDTO response = this.departamentoService.criaProjeto(dto);
        return response;
    }

    @PostMapping("/gerenciar-meta")
    @ResponseStatus(HttpStatus.CREATED)
    public MetaPostDTO criaMeta(@RequestBody MetaPostDTO dto){
        return this.departamentoService.criaMeta(dto);
    }

    @PostMapping("/gerenciar-servico")
    @ResponseStatus(HttpStatus.CREATED)
    public ServicoPostDTO criaServico(@RequestBody ServicoPostDTO dto){
        return this.departamentoService.registraServico(dto);
    }
    @PostMapping("/gerenciar-beneficiario")
    @ResponseStatus(HttpStatus.CREATED)
    public BeneficiarioPostDTO criaServico(@RequestBody BeneficiarioPostDTO dto){
        return this.beneficiarioService.registraBeneficiario(dto);
    }
}
