package com.jp.agrodata.jpagrodata.services.impls;

import com.jp.agrodata.jpagrodata.configs.Configuration;
import com.jp.agrodata.jpagrodata.dtos.EmpresaDTO;
import com.jp.agrodata.jpagrodata.models.entities.Empresa;
import com.jp.agrodata.jpagrodata.models.enums.EnumSimNao;
import com.jp.agrodata.jpagrodata.services.EmpresaService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
@Service
public class EmpresaServiceImpl implements EmpresaService {

    private Configuration config;

    public EmpresaServiceImpl(Configuration config) {
        this.config = config;
    }

    @Override
    public EmpresaDTO save(EmpresaDTO dto) {
        Empresa empresa = this.toEmpresa(dto);
        EmpresaDTO empresaDto = this.toEmpresaDTO(empresa);
        return dto;
    }

    @Override
    public Empresa toEmpresa(EmpresaDTO dto) {
        Empresa empresa = Empresa.builder()
                .cnpj(dto.getCnpj())
                .codIBGEMunicipio(dto.getCodIBGEMunicipio())
                .contatoEmpresa(dto.getContatoEmpresa())
                .contatoRepresentante(dto.getContatoRepresentante())
                .cpfRepresentante(dto.getCpfRepresentante())
                .dataAtivacao(LocalDate.parse(dto.getDataAtivacao()))
                .dataDesativacao(LocalDate.parse(dto.getDataDesativacao()))
                .emailEmpresa(dto.getEmailEmpresa())
                .emailRepresentante(dto.getEmailRepresentante())
                .endereco(dto.getEndereco())
                .nomeFantasia(dto.getNomeFantasia())
                .nomeRepresentante(dto.getNomeRepresentante())
                .ativo(EnumSimNao.valueOf(dto.getAtivo()))
                .build();
        return empresa;
    }

    @Override
    public EmpresaDTO toEmpresaDTO(Empresa empresa) {

        EmpresaDTO response = EmpresaDTO.builder()
                .cnpj(empresa.getCnpj())
                .codIBGEMunicipio(empresa.getCodIBGEMunicipio())
                .contatoEmpresa(empresa.getContatoEmpresa())
                .contatoRepresentante(empresa.getContatoRepresentante())
                .cpfRepresentante(empresa.getCpfRepresentante())
                .dataAtivacao(empresa.getDataAtivacao().format(config.formatterddMMyyyy()))
                .dataDesativacao(empresa.getDataDesativacao().format(config.formatterddMMyyyy()))
                .emailEmpresa(empresa.getEmailEmpresa())
                .emailRepresentante(empresa.getEmailRepresentante())
                .endereco(empresa.getEndereco())
                .nomeFantasia(empresa.getNomeFantasia())
                .nomeRepresentante(empresa.getNomeRepresentante())
                .ativo(empresa.getAtivo().toString())
                .build();
        return response;
    }
}
