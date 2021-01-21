package com.jp.agrodata.jpagrodata.controllers;

import com.jp.agrodata.jpagrodata.dtos.DepartamentoDTO;
import com.jp.agrodata.jpagrodata.services.DepartamentoService;
import com.jp.agrodata.jpagrodata.services.ProjetoService;
import com.jp.agrodata.jpagrodata.services.impls.DepartamentoServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/departamento")
@Slf4j
public class DepartamentoController {

    private DepartamentoService departamentoService;

    public DepartamentoController(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DepartamentoDTO criaDepartamento(@RequestBody DepartamentoDTO dto){
        DepartamentoDTO response = departamentoService.save(dto);
        return response;
    }
}
