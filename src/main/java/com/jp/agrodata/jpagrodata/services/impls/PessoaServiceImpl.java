package com.jp.agrodata.jpagrodata.services.impls;

import com.jp.agrodata.jpagrodata.configs.Configuration;
import com.jp.agrodata.jpagrodata.dtos.ClienteDTO;
import com.jp.agrodata.jpagrodata.dtos.UsuarioDTO;
import com.jp.agrodata.jpagrodata.models.entities.ClientePF;
import com.jp.agrodata.jpagrodata.models.entities.Usuario;
import com.jp.agrodata.jpagrodata.models.enums.*;
import com.jp.agrodata.jpagrodata.models.repositories.ClientePFRepository;
import com.jp.agrodata.jpagrodata.services.PessoaService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PessoaServiceImpl implements PessoaService {

    private Configuration config;
    private ClientePFRepository repository;

    public PessoaServiceImpl(Configuration config,
                             ClientePFRepository repository
    ) {
        this.config = config;
        this.repository = repository;
    }

    @Override
    public ClienteDTO save(ClienteDTO dto) {
        //Verifica se existe o cpf no registro desta empresa
        if(dto.getId()==null){
            dto.setId("123");
        }
        ClientePF cliente = toClientePF(dto);

        cliente = this.repository.save(cliente);
        ClienteDTO clienteDto = toClienteDTO(cliente);
        return clienteDto;
    }

    @Override
    public UsuarioDTO save(UsuarioDTO usuarioDTO) {
        Usuario usuario = toUsuario(usuarioDTO);
        UsuarioDTO response = toUsuarioDTO(usuario);

        return response;
    }

    private UsuarioDTO toUsuarioDTO(Usuario dto) {
        UsuarioDTO response = new UsuarioDTO();
        response.setCpf(response.getCpf());
        response.setDepartamento(dto.getDepartamento());
        response.setMatricula(dto.getMatricula());
        response.setRegistroConselho(dto.getRegistroConselho());
        response.setRole(EnumRole.valueOf(dto.getRole().toString()));
        response.setSenha(dto.getSenha());
        response.setEmail(dto.getEmail());
        response.setEndereco(dto.getEndereco());
        response.setFoneContato(dto.getFoneContato());
        response.setAtivo(dto.getAtivo().toString());
        return response;
    }

    private Usuario toUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setCpf(usuario.getCpf());
        usuario.setDepartamento(usuarioDTO.getDepartamento());
        usuario.setMatricula(usuarioDTO.getMatricula());
        usuario.setRegistroConselho(usuarioDTO.getRegistroConselho());
        usuario.setRole(EnumRole.valueOf(usuarioDTO.getRole().toString()));
        usuario.setSenha(usuarioDTO.getSenha());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setEndereco(usuarioDTO.getEndereco());
        usuario.setFoneContato(usuarioDTO.getFoneContato());
        usuario.setAtivo(EnumSimNao.valueOf(usuarioDTO.getAtivo()));
        return usuario;
    }

    private ClienteDTO toClienteDTO(ClientePF cliente) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(cliente.getId().toString());
        dto.setNome(cliente.getNome());
        dto.setWhatsapp(cliente.getWhatsapp());
        dto.setApelido(cliente.getApelido());
        dto.setCategoria(cliente.getCategoria().toString());
        dto.setCpf(cliente.getCpf());
        dto.setContato(cliente.getFoneContato());
        dto.setDataDeNascimento(cliente.getDataDeNascimento().format(config.formatterddMMyyyy()));
        dto.setEmail(cliente.getEmail());
        dto.setEndereco(cliente.getEndereco());
        dto.setEscolaridade(cliente.getEscolaridade().toString());
        dto.setGenero(cliente.getGenero().toString());
        dto.setRaca(cliente.getRaca().toString());
        return dto;
    }

    private ClientePF toClientePF(ClienteDTO cliente) {
        ClientePF response = new ClientePF();
        response.setId(Long.valueOf(cliente.getId()));
        response.setApelido(cliente.getApelido());
        response.setNome(cliente.getNome());
        response.setWhatsapp(cliente.getWhatsapp());
        response.setCategoria(EnumCategoria.valueOf(cliente.getCategoria()));
        response.setCpf(cliente.getCpf());
        response.setFoneContato(cliente.getContato());
        response.setDataDeNascimento(LocalDate.parse(cliente.getDataDeNascimento(), config.formatterddMMyyyy()));
        response.setEmail(cliente.getEmail());
        response.setEndereco(cliente.getEndereco());
        response.setEscolaridade(EnumEscolaridade.valueOf(cliente.getEscolaridade().toString()));
        response.setGenero(EnumGenero.valueOf(cliente.getGenero()));
        response.setRaca(EnumRaca.valueOf(cliente.getRaca()));
        return response;
    }
}
