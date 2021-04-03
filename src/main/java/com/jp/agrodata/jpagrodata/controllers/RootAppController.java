package com.jp.agrodata.jpagrodata.controllers;

import com.jp.agrodata.jpagrodata.dtos.*;
import com.jp.agrodata.jpagrodata.services.ContratoService;
import com.jp.agrodata.jpagrodata.services.EmpresaService;
import com.jp.agrodata.jpagrodata.services.MunicipioService;
import com.jp.agrodata.jpagrodata.services.impls.ContratoServiceImpl;
import com.jp.agrodata.jpagrodata.services.impls.EmpresaServiceImpl;
import com.jp.agrodata.jpagrodata.services.impls.MunicipioServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/root")
@Slf4j
public class RootAppController {

    private EmpresaService empresaService;
    private ContratoService contratoService;
    private MunicipioService municipioService;

    public RootAppController(
            EmpresaService empresaService,
            ContratoService contratoService,
            MunicipioService municipioService
    ) {
        this.empresaService = empresaService;
        this.contratoService = contratoService;
        this.municipioService = municipioService;
    }

    @PostMapping("/empresa")
    @ResponseStatus(HttpStatus.CREATED)
    public EmpresaDTO registraEmpresa(@RequestBody @Valid EmpresaDTO dto){
        return this.empresaService.save(dto);
    }

    @GetMapping("/empresa")
    @ResponseStatus(HttpStatus.OK)
    public EmpresaDTO getEmpresa(@RequestParam Integer id){
        return this.empresaService.obterEmpresa(id);
    }

    @PostMapping("/contrato")
    @ResponseStatus(HttpStatus.CREATED)
    public ContratoDto criaContrato(@RequestBody @Valid ContratoDto dto){
        return this.contratoService.save(dto);
    }

    @PostMapping("/municipio")
    @ResponseStatus(HttpStatus.CREATED)
    public MunicipioDto criaMunicipio(@RequestBody @Valid MunicipioDto dto){
        return this.municipioService.save(dto);
    }

    @PostMapping("/contrato/plano")
    @ResponseStatus(HttpStatus.CREATED)
    public PlanoDto criaPlano(@RequestBody @Valid PlanoDto dto){
        return this.contratoService.savePlano(dto);
    }

    @PostMapping("/contrato/clausula")
    @ResponseStatus(HttpStatus.CREATED)
    public ClausulaDto criaPlano(@RequestBody @Valid ClausulaDto dto){
        return this.contratoService.saveClausula(dto);
    }
}
