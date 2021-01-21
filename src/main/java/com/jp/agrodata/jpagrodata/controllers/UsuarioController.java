package com.jp.agrodata.jpagrodata.controllers;

import com.jp.agrodata.jpagrodata.dtos.UsuarioDTO;
import com.jp.agrodata.jpagrodata.services.PessoaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/usuarios")
@Slf4j
public class UsuarioController {
    private PessoaService pessoaService;

    public UsuarioController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDTO registrar(@RequestBody UsuarioDTO dto){
        return this.pessoaService.save(dto);
    }
}
