package com.jp.agrodata.jpagrodata.services.impls;

import com.jp.agrodata.jpagrodata.configs.Configuration;
import com.jp.agrodata.jpagrodata.dtos.ClienteDTO;
import com.jp.agrodata.jpagrodata.dtos.UsuarioDTO;
import com.jp.agrodata.jpagrodata.models.embeddeds.Contato;
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
        Contato contato = dto.getContato();

        UsuarioDTO response = new UsuarioDTO();
        response.setCpf(response.getCpf());
        response.setDepartamento(dto.getDepartamento());
        response.setMatricula(dto.getMatricula());
        response.setRegistroConselho(dto.getRegistroConselho());
        response.setRole(EnumRole.valueOf(dto.getRole().toString()));
        response.setSenha(dto.getSenha());
        response.setEmail(contato.getEmail());
        response.setWhatsapp(contato.getWhatsapp());
        response.setMunicipio(contato.getMunicipio());
        response.setEndereco(contato.getEndereco());
        response.setFoneContato(contato.getFoneContato());
        response.setAtivo(dto.getAtivo().toString());

        return response;
    }

    private Usuario toUsuario(UsuarioDTO usuarioDTO) {

        Usuario usuario = new Usuario();
        //definindo os dados de contato
        Contato contato = new Contato();
        contato.setEmail(usuarioDTO.getEmail());
        contato.setEndereco(usuarioDTO.getEndereco());
        contato.setFoneContato(usuarioDTO.getFoneContato());
        contato.setWhatsapp(usuarioDTO.getWhatsapp());
        contato.setMunicipio(usuarioDTO.getMunicipio());

        usuario.setCpf(usuario.getCpf());
        usuario.setDepartamento(usuarioDTO.getDepartamento());
        usuario.setMatricula(usuarioDTO.getMatricula());
        usuario.setRegistroConselho(usuarioDTO.getRegistroConselho());
        usuario.setRole(EnumRole.valueOf(usuarioDTO.getRole().toString()));
        usuario.setSenha(usuarioDTO.getSenha());
        usuario.setContato(contato);
        usuario.setAtivo(EnumSimNao.valueOf(usuarioDTO.getAtivo()));

        return usuario;
    }

    private ClienteDTO toClienteDTO(ClientePF cliente) {
        Contato contato = cliente.getContato();

        ClienteDTO dto = new ClienteDTO();
        dto.setId(cliente.getId().toString());
        dto.setNome(cliente.getNome());
        dto.setWhatsapp(contato.getWhatsapp());
        dto.setApelido(cliente.getApelido());
        dto.setCategoria(cliente.getCategoria().toString());
        dto.setCpf(cliente.getCpf());
        dto.setContato(contato.getFoneContato());
        dto.setDataDeNascimento(cliente.getDataDeNascimento().format(config.formatterddMMyyyy()));
        dto.setEmail(contato.getEmail());
        dto.setEndereco(contato.getEndereco());
        dto.setMunicipio(contato.getMunicipio());
        dto.setEscolaridade(cliente.getEscolaridade().toString());
        dto.setGenero(cliente.getGenero().toString());
        dto.setRaca(cliente.getRaca().toString());
        return dto;
    }

    private ClientePF toClientePF(ClienteDTO cliente) {

        ClientePF response = new ClientePF();

        //definindo os dados de contato
        Contato contato = new Contato();
        contato.setWhatsapp(cliente.getWhatsapp());
        contato.setFoneContato(cliente.getContato());
        contato.setEmail(cliente.getEmail());
        contato.setEndereco(cliente.getEndereco());
        contato.setMunicipio(cliente.getMunicipio());

        response.setId(Long.valueOf(cliente.getId()));
        response.setContato(contato);
        response.setApelido(cliente.getApelido());
        response.setNome(cliente.getNome());
        response.setCategoria(EnumCategoria.valueOf(cliente.getCategoria()));
        response.setCpf(cliente.getCpf());
        response.setDataDeNascimento(LocalDate.parse(cliente.getDataDeNascimento(), config.formatterddMMyyyy()));
        response.setEscolaridade(EnumEscolaridade.valueOf(cliente.getEscolaridade().toString()));
        response.setGenero(EnumGenero.valueOf(cliente.getGenero()));
        response.setRaca(EnumRaca.valueOf(cliente.getRaca()));
        return response;
    }
}
