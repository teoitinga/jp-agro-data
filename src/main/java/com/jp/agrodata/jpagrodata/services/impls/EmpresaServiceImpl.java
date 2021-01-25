package com.jp.agrodata.jpagrodata.services.impls;

import com.jp.agrodata.jpagrodata.configs.Configuration;
import com.jp.agrodata.jpagrodata.dtos.CargoDTO;
import com.jp.agrodata.jpagrodata.dtos.DepartamentoDTO;
import com.jp.agrodata.jpagrodata.dtos.EmpresaDTO;
import com.jp.agrodata.jpagrodata.exceptions.EmpresaNotFoundException;
import com.jp.agrodata.jpagrodata.models.entities.Cargo;
import com.jp.agrodata.jpagrodata.models.entities.Departamento;
import com.jp.agrodata.jpagrodata.models.entities.Empresa;
import com.jp.agrodata.jpagrodata.models.repositories.CargoRepository;
import com.jp.agrodata.jpagrodata.models.repositories.EmpresaRepository;
import com.jp.agrodata.jpagrodata.services.DepartamentoService;
import com.jp.agrodata.jpagrodata.services.EmpresaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Service
@Slf4j
public class EmpresaServiceImpl implements EmpresaService {

    private Configuration config;
    private EmpresaRepository repository;
    private DepartamentoService departamentoService;
    private CargoRepository cargoRepository;

    public EmpresaServiceImpl(
            EmpresaRepository repository,
            CargoRepository cargoRepository,
            DepartamentoService departamentoService,
            Configuration config) {
        this.repository = repository;
        this.cargoRepository = cargoRepository;
        this.departamentoService = departamentoService;
        this.config = config;
    }

    @Override
    public EmpresaDTO save(EmpresaDTO dto) {
        Empresa empresa = this.toEmpresa(dto);

        empresa = this.repository.save(empresa);

        return this.toEmpresaDTO(empresa);
    }

    @Override
    public Empresa toEmpresa(EmpresaDTO dto) {
        Empresa empresa = Empresa.builder()
                .id(dto.getId())
                .cnpj(dto.getCnpj())
                .codIBGEMunicipio(dto.getCodIBGEMunicipio())
                .contatoEmpresa(dto.getContatoEmpresa())
                .contatoRepresentante(dto.getContatoRepresentante())
                .cpfRepresentante(dto.getCpfRepresentante())
                .emailEmpresa(dto.getEmailEmpresa())
                .emailRepresentante(dto.getEmailRepresentante())
                .endereco(dto.getEndereco())
                .nomeFantasia(dto.getNomeFantasia())
                .nomeRepresentante(dto.getNomeRepresentante())
                .build();
        return empresa;
    }

    @Override
    public EmpresaDTO toEmpresaDTO(Empresa empresa) {
        EmpresaDTO response = EmpresaDTO.builder()
                .id(empresa.getId())
                .cnpj(empresa.getCnpj())
                .codIBGEMunicipio(empresa.getCodIBGEMunicipio())
                .contatoEmpresa(empresa.getContatoEmpresa())
                .contatoRepresentante(empresa.getContatoRepresentante())
                .cpfRepresentante(empresa.getCpfRepresentante())
                .emailEmpresa(empresa.getEmailEmpresa())
                .emailRepresentante(empresa.getEmailRepresentante())
                .endereco(empresa.getEndereco())
                .nomeFantasia(empresa.getNomeFantasia())
                .nomeRepresentante(empresa.getNomeRepresentante())
                .build();
        return response;
    }

    @Override
    public Empresa findById(Integer codEmpresa) {
        return this.repository.findById(codEmpresa).orElseThrow(()->new EmpresaNotFoundException());
    }

    @Override
    public DepartamentoDTO saveDepartamento(DepartamentoDTO dto) {

        Empresa empresa = this.findById(dto.getCodEmpresaVinculada());
        Departamento departamento = this.departamentoService.toDepartamento(dto, empresa);
        departamento = this.departamentoService.saveDepartamento(departamento);
        DepartamentoDTO response = this.departamentoService.toDepartamentoDTO(departamento);
        return response;
    }

    @Override
    public CargoDTO saveCargo(CargoDTO dto) {
        Cargo cargo = toCargo(dto);
        cargo = this.cargoRepository.save(cargo);
        CargoDTO response = toCargoDTO(cargo);
        return response;
    }

    @Override
    public Empresa findByCnpj(String cnpj) {
        return this.repository.findByCnpj(cnpj).orElseThrow(()->new EmpresaNotFoundException());
    }

    private Cargo toCargo(CargoDTO cargo) {

        Empresa empresa = this.findById(cargo.getCodEmpresaVinculada());

        return Cargo.builder()
                .empresaVinculada(empresa)
                .descricaoDoCargo(cargo.getDescricaoDoCargo())
                .horasTrabalhadas(cargo.getHorasTrabalhadas())
                .nomeDoCargo(cargo.getNomeDoCargo())
                .salarioBase(cargo.getSalarioBase())
                .build();
    }

    private CargoDTO toCargoDTO(Cargo cargo) {
        return CargoDTO.builder()
                .codEmpresaVinculada(cargo.getEmpresaVinculada().getId())
                .descricaoDoCargo(cargo.getDescricaoDoCargo())
                .horasTrabalhadas(cargo.getHorasTrabalhadas())
                .nomeDoCargo(cargo.getNomeDoCargo())
                .salarioBase(cargo.getSalarioBase())
                .build();
    }
}
