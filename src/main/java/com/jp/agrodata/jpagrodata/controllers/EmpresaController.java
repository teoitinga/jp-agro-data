package com.jp.agrodata.jpagrodata.controllers;

import com.jp.agrodata.jpagrodata.dtos.CargoDTO;
import com.jp.agrodata.jpagrodata.dtos.DepartamentoDTO;
import com.jp.agrodata.jpagrodata.services.EmpresaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/empresa")
@Slf4j
public class EmpresaController {

    private EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @PostMapping("gerenciar-departamento")
    @ResponseStatus(HttpStatus.CREATED)
    public DepartamentoDTO criaDepartamento(@RequestBody DepartamentoDTO dto){

        return this.empresaService.saveDepartamento(dto);
    }
    @PostMapping("gerenciar-cargo")
    @ResponseStatus(HttpStatus.CREATED)
    public CargoDTO criarCargo(@RequestBody CargoDTO dto){
        return this.empresaService.saveCargo(dto);
    }
}
