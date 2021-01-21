package com.jp.agrodata.jpagrodata.controllers;

import com.jp.agrodata.jpagrodata.dtos.ClienteDTO;
import com.jp.agrodata.jpagrodata.services.PessoaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pessoas")
@Slf4j
public class PessoalController {

    private PessoaService pessoaService;

    public PessoalController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteDTO registrar(@RequestBody ClienteDTO dto){
        return this.pessoaService.save(dto);
    }
}
