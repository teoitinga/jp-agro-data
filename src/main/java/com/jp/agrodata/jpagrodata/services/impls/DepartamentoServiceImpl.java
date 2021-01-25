package com.jp.agrodata.jpagrodata.services.impls;

import com.jp.agrodata.jpagrodata.configs.Configuration;
import com.jp.agrodata.jpagrodata.dtos.*;
import com.jp.agrodata.jpagrodata.exceptions.DepartamentoNotFoundException;
import com.jp.agrodata.jpagrodata.exceptions.ProjetoNotFoundException;
import com.jp.agrodata.jpagrodata.exceptions.UnidadeNotFoundException;
import com.jp.agrodata.jpagrodata.models.entities.*;
import com.jp.agrodata.jpagrodata.models.repositories.*;
import com.jp.agrodata.jpagrodata.services.DepartamentoService;
import com.jp.agrodata.jpagrodata.services.EmpresaService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

    private Configuration config;
    private DepartamentoRepository repository;
    private ProjetoRepository projetoRepository;
    private MetaRepository metaRepository;
    private UnidadeRepository unidadeRepository;
    private ServicoRepository servicoRespository;

    public DepartamentoServiceImpl(
            DepartamentoRepository repository,
            ProjetoRepository projetoRepository,
            MetaRepository metaRepository,
            UnidadeRepository unidadeRepository,
            ServicoRepository servicoRespository,
            Configuration config
    ) {
        this.repository = repository;
        this.projetoRepository = projetoRepository;
        this.metaRepository = metaRepository;
        this.unidadeRepository = unidadeRepository;
        this.servicoRespository = servicoRespository;
        this.config = config;
    }

    @Override
    public DepartamentoDTO toDepartamentoDTO(Departamento departamento) {
        String desativadoEm;
        try{
            desativadoEm = departamento.getDataDesativacao().format(config.formatterddMMyyyy());
        }catch (NullPointerException exc){
            desativadoEm = null;
        }
        return DepartamentoDTO.builder()
                .nomeRepresentante(departamento.getNomeRepresentante())
                .nome(departamento.getNome())
                .endereco(departamento.getEndereco())
                .emailRepresentante(departamento.getEmailRepresentante())
                .dataDesativacao(desativadoEm)
                .dataAtivacao(departamento.getDataAtivacao().format(config.formatterddMMyyyy()))
                .email(departamento.getEmail())
                .cpfRepresentante(departamento.getCpfRepresentante())
                .contatoRepresentante(departamento.getContatoRepresentante())
                .contato(departamento.getContato())
                .codIBGEMunicipio(departamento.getCodIBGEMunicipio())
                .id(departamento.getId())
                .CodEmpresaVinculada(departamento.getEmpresaVinculada().getId())
                .setor(departamento.getSetor())
                .build();
    }

    @Override
    public Departamento toDepartamento(DepartamentoDTO departamento, Empresa empresaInfo) {
        Empresa empresa = empresaInfo;
        LocalDate desativaDoEm;
        try{
            desativaDoEm = LocalDate.parse(departamento.getDataDesativacao(), config.formatterddMMyyyy());
        }catch (NullPointerException exc){
            desativaDoEm = null;
        }
        return Departamento.builder()
                .nomeRepresentante(departamento.getNomeRepresentante())
                .nome(departamento.getNome())
                .endereco(departamento.getEndereco())
                .emailRepresentante(departamento.getEmailRepresentante())
                .dataDesativacao(desativaDoEm)
                .dataAtivacao(LocalDate.parse(departamento.getDataAtivacao(), config.formatterddMMyyyy()))
                .email(departamento.getEmail())
                .cpfRepresentante(departamento.getCpfRepresentante())
                .contatoRepresentante(departamento.getContatoRepresentante())
                .contato(departamento.getContato())
                .codIBGEMunicipio(departamento.getCodIBGEMunicipio())
                .id(departamento.getId())
                .empresaVinculada(empresa)
                .setor(departamento.getSetor())
                .build();
    }

    @Override
    public ProjetoDTO criaProjeto(ProjetoDTO dto) {

        Projeto projeto = toProjeto(dto);
        projeto = this.projetoRepository.save(projeto);
        ProjetoDTO response = toProjetoDTO(projeto);

        return response;
    }

    @Override
    public Departamento saveDepartamento(Departamento departamento) {
        return this.repository.save(departamento);
    }

    @Override
    public MetaPostDTO criaMeta(MetaPostDTO dto) {
        //Verifica os serviços
        List<Integer> codServicos = dto.getServicos();
        List<Servico> servicos = codServicos.stream().map(srv->toServico(srv))
                .filter(srv->srv!=null)
                .collect(Collectors.toList());


        Meta meta = toMeta(dto);
        meta.setServicos(servicos);
        meta = this.metaRepository.save(meta);
        MetaPostDTO response = toMetaPostDTO(meta);
        return response;
    }

    @Override
    public ServicoPostDTO registraServico(ServicoPostDTO dto) {
        Servico servico = toServico(dto);
        servico = this.servicoRespository.save(servico);
        return toServicoDTO(servico);
    }

    private Servico toServico(ServicoPostDTO servico) {
        return Servico.builder()
                .descricao(servico.getDescricao())
                .referencia(servico.getReferencia())
                .tempoNecessario(servico.getTempoNecessario())
                .valor(servico.getValor())
                .build();
    }

    private ServicoPostDTO toServicoDTO(Servico servico) {
        return ServicoPostDTO.builder()
                .descricao(servico.getDescricao())
                .referencia(servico.getReferencia())
                .tempoNecessario(servico.getTempoNecessario())
                .valor(servico.getValor())
                .build();
    }

    private Servico toServico(Integer srv) {
        Optional<Servico> servico = this.servicoRespository.findById(srv);
        if(servico.isPresent()){
            return servico.get();
        }else {
            return null;
        }

    }

    private MetaPostDTO toMetaPostDTO(Meta dto) {
        String dataFim = dto.getFim().format(config.formatterddMMyyyy());

        String dataInicio = dto.getInicio().format(config.formatterddMMyyyy());

        return MetaPostDTO.builder()
                .descricao(dto.getDescricao())
                .fim(dataFim)
                .inicio(dataInicio)
                .quantidade(dto.getQuantidade())
                .resultado(dto.getResultado())
                .codUnidade(dto.getUnidade().getId())
                .codProjeto(dto.getProjeto().getId())
                .build();
    }

    private Meta toMeta(MetaPostDTO dto) {
        Unidade unidade = this.unidadeRepository.findById(dto.getCodUnidade()).orElseThrow(()->new UnidadeNotFoundException());
        Projeto projeto = this.projetoRepository.findById(dto.getCodProjeto()).orElseThrow(()->new ProjetoNotFoundException());
        List<Servico> servicos = null;
        LocalDate dataFim = LocalDate.parse(dto.getFim(), config.formatterddMMyyyy());

        LocalDate dataInicio = LocalDate.parse(dto.getInicio(), config.formatterddMMyyyy());

        return Meta.builder()
                .descricao(dto.getDescricao())
                .fim(dataFim)
                .inicio(dataInicio)
                .quantidade(dto.getQuantidade())
                .resultado(dto.getResultado())
                .unidade(unidade)
                .projeto(projeto)
                .servicos(servicos)
                .build();
    }

    private MetaDTO toMetaDTO(Meta mete) {
        return MetaDTO.builder()
                .descricao(mete.getDescricao())
                .fim(mete.getFim())
                .inicio(mete.getInicio())
                .quantidade(mete.getQuantidade())
                .resultado(mete.getResultado())
                .unidade(mete.getUnidade())
                .build();
    }

    private ProjetoDTO toProjetoDTO(Projeto projeto) {
        return ProjetoDTO.builder()
                .id(projeto.getId())
                .codDepartamento(projeto.getDepartamento().getId())
                .codIBGEMunicipio(projeto.getCodIBGEMunicipio())
                .cpfResponsavel(projeto.getCpfResponsavel())
                .descricao(projeto.getDescricao())
                .fim(projeto.getFim().format(config.formatterddMMyyyy()))
                .inicio(projeto.getInicio().format(config.formatterddMMyyyy()))
                .justificativa(projeto.getJustificativa())
                .nomeDoProjeto(projeto.getNomeDoProjeto())
                .numDeBeneficiarios(projeto.getNumDeBeneficiarios())
                .objetivoEspecifico(projeto.getObjetivoEspecifico())
                .objetivoGeral(projeto.getObjetivoGeral())
                .parceiros(projeto.getParceiros())
                .publicoAlvo(projeto.getPublicoAlvo())
                .resultadosEsperados(projeto.getResultadosEsperados())
                .valorOrcado(projeto.getValorOrcado().doubleValue())
                .build();
    }

    private Projeto toProjeto(ProjetoDTO dto) {
        Departamento departamento = this.finById(dto.getCodDepartamento());
        return Projeto.builder()
                .id(dto.getId())
                .departamento(departamento)
                .codIBGEMunicipio(dto.getCodIBGEMunicipio())
                .cpfResponsavel(dto.getCpfResponsavel())
                .descricao(dto.getDescricao())
                .fim(LocalDate.parse(dto.getFim(), config.formatterddMMyyyy()))
                .inicio(LocalDate.parse(dto.getInicio(),config.formatterddMMyyyy()))
                .justificativa(dto.getJustificativa())
                .nomeDoProjeto(dto.getNomeDoProjeto())
                .numDeBeneficiarios(dto.getNumDeBeneficiarios())
                .objetivoEspecifico(dto.getObjetivoEspecifico())
                .objetivoGeral(dto.getObjetivoGeral())
                .parceiros(dto.getParceiros())
                .publicoAlvo(dto.getPublicoAlvo())
                .resultadosEsperados(dto.getResultadosEsperados())
                .valorOrcado(BigDecimal.valueOf(dto.getValorOrcado()))
                .build();
    }

    private Departamento finById(Integer codDepartamento) {
        return this.repository.findById(codDepartamento).orElseThrow(()->new DepartamentoNotFoundException());
    }
}
