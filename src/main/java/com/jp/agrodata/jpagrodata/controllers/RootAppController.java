package com.jp.agrodata.jpagrodata.controllers;

import com.jp.agrodata.jpagrodata.dtos.*;
import com.jp.agrodata.jpagrodata.services.*;
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
    private BancoService bancoService;
    private ClSetoresService clSetoresService;
    private UnidadeService unidadeService;

    public RootAppController(
            EmpresaService empresaService,
            ContratoService contratoService,
            MunicipioService municipioService,
            BancoService bancoService,
            ClSetoresService clSetoresService,
            UnidadeService unidadeService
    ) {
        this.empresaService = empresaService;
        this.contratoService = contratoService;
        this.municipioService = municipioService;
        this.bancoService = bancoService;
        this.clSetoresService = clSetoresService;
        this.unidadeService = unidadeService;
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

    @PutMapping("/empresa")
    @ResponseStatus(HttpStatus.OK)
    public EmpresaDTO updateEmpresa(@RequestBody @Valid EmpresaDTO dto, @RequestParam String id){
        log.info("ID:" + id);
        return this.empresaService.update(dto, id);
    }
    @PostMapping("/contrato")
    @ResponseStatus(HttpStatus.CREATED)
    public ContratoDto criaContrato(@RequestBody @Valid ContratoDto dto){
        return this.contratoService.save(dto);
    }

    @GetMapping("/contrato")
    @ResponseStatus(HttpStatus.OK)
    public ContratoDto getContrato(@RequestParam Integer id){
        return this.contratoService.getContrato(id);
    }

    @PostMapping("/municipio")
    @ResponseStatus(HttpStatus.CREATED)
    public MunicipioDto criaMunicipio(@RequestBody @Valid MunicipioDto dto){
        return this.municipioService.save(dto);
    }

    @GetMapping("/municipio")
    @ResponseStatus(HttpStatus.OK)
    public MunicipioDto getContrato(@RequestParam String id){
        return this.municipioService.getMunicipio(id);
    }

    @PostMapping("/contrato/plano")
    @ResponseStatus(HttpStatus.CREATED)
    public PlanoDto criaPlano(@RequestBody @Valid PlanoDto dto){
        return this.contratoService.savePlano(dto);
    }

    @GetMapping("/contrato/plano")
    @ResponseStatus(HttpStatus.OK)
    public PlanoDto getPlano(@RequestParam Integer id){
        return this.contratoService.getPlano(id);
    }

    @PostMapping("/contrato/clausula")
    @ResponseStatus(HttpStatus.CREATED)
    public ClausulaDto criaClausula(@RequestBody @Valid ClausulaDto dto){
        return this.contratoService.saveClausula(dto);
    }

    @GetMapping("/contrato/clausula")
    @ResponseStatus(HttpStatus.OK)
    public ClausulaDto getClausula(@RequestParam Integer id){
        return this.contratoService.getClausula(id);
    }
    /*
    Registro de Bancos
     */
    @PostMapping("/banco")
    @ResponseStatus(HttpStatus.CREATED)
    public BancoDto criaBanco(@RequestBody @Valid BancoDto dto){
        return this.bancoService.saveBanco(dto);
    }

    @GetMapping("/banco")
    @ResponseStatus(HttpStatus.OK)
    public BancoDto getBanco(@RequestParam String id){
        return this.bancoService.getBanco(id);
    }
    /*
    Registro de Agencia Bancária
     */
    @PostMapping("/agenciabancaria")
    @ResponseStatus(HttpStatus.CREATED)
    public AgenciaBancariaDto criaAgenciaBancaria(@RequestBody @Valid AgenciaBancariaDto dto){
        return this.bancoService.saveAgencia(dto);
    }

    @GetMapping("/agenciabancaria")
    @ResponseStatus(HttpStatus.OK)
    public AgenciaBancariaDto getAgenciaBancaria(@RequestParam String id){
        return this.bancoService.getAgencia(id);
    }

    /*
    Registro de Conta Bancária
     */
    @PostMapping("/contabancaria")
    @ResponseStatus(HttpStatus.CREATED)
    public ContaBancariaDto criaContaBancaria(@RequestBody @Valid ContaBancariaDto dto){
        return this.bancoService.saveConta(dto);
    }

    @GetMapping("/contabancaria")
    @ResponseStatus(HttpStatus.OK)
    public ContaBancariaDto getContaBancaria(@RequestParam String id){
        return this.bancoService.getConta(id);
    }

    /*
    Registro de Classe de Setores
     */
    @PostMapping("/clsetores")
    @ResponseStatus(HttpStatus.CREATED)
    public SetorClassDto criaSetorClass(@RequestBody @Valid SetorClassDto dto){
        return this.clSetoresService.save(dto);
    }

    @GetMapping("/clsetores")
    @ResponseStatus(HttpStatus.OK)
    public SetorClassDto getSetorClass(@RequestParam String id){
        return this.clSetoresService.getById(id);
    }

    /*
    Registro de Unidades de medida
     */
    @PostMapping("/unidades")
    @ResponseStatus(HttpStatus.CREATED)
    public UnidadeDto criaUnidade(@RequestBody @Valid UnidadeDto dto){
        return this.unidadeService.save(dto);
    }

    @GetMapping("/unidades")
    @ResponseStatus(HttpStatus.OK)
    public UnidadeDto getUnidade(@RequestParam String id){
        return this.unidadeService.getById(id);
    }
}
