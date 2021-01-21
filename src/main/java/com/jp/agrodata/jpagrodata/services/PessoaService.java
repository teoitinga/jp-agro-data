package com.jp.agrodata.jpagrodata.services;

import com.jp.agrodata.jpagrodata.dtos.ClienteDTO;
import com.jp.agrodata.jpagrodata.dtos.UsuarioDTO;

public interface PessoaService {
    ClienteDTO save(ClienteDTO dto);

    UsuarioDTO save(UsuarioDTO usuarioDTO);
}
