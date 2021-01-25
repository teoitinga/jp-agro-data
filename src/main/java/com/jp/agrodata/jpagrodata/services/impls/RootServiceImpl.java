package com.jp.agrodata.jpagrodata.services.impls;

import com.jp.agrodata.jpagrodata.configs.Configuration;
import com.jp.agrodata.jpagrodata.dtos.*;
import com.jp.agrodata.jpagrodata.exceptions.AppNotFoundException;
import com.jp.agrodata.jpagrodata.exceptions.BancoNotFoundException;
import com.jp.agrodata.jpagrodata.models.entities.*;
import com.jp.agrodata.jpagrodata.models.repositories.*;
import com.jp.agrodata.jpagrodata.services.EmpresaService;
import com.jp.agrodata.jpagrodata.services.RootService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RootServiceImpl implements RootService {

    private AgenciaBancariaRepository agenciaRepository;
    private BancoRepository bancoRepository;
    private ContaRepository contaRepository;
    private EmpresaService empresaService;
    private MessageRepository messageRepository;
    private UnidadeRepository unidadeRepository;
    private RootRepository rootRepository;
    private Configuration config;
    private ConttratoRepository contratoRepository;
    private ServicoRepository servicoRepository;
    private SituacaoRepository situacaoRepository;
    private OrientacaoRepository orientacaoRepository;
    private RecomendacaoRepository recomendacaoRepository;

    public RootServiceImpl(
            RootRepository rootRepository,
            BancoRepository bancoRepository,
            AgenciaBancariaRepository agenciaRepository,
            ContaRepository contaRepository,
            UnidadeRepository unidadeRepository,
            MessageRepository messageRepository,
            ConttratoRepository contratoRepository,
            ServicoRepository servicoRepository,
            SituacaoRepository situacaoRepository,
            OrientacaoRepository orientacaoRepository,
            RecomendacaoRepository recomendacaoRepository,
            EmpresaService empresaService,
            Configuration config
    ) {
        this.rootRepository = rootRepository;
        this.bancoRepository = bancoRepository;
        this.agenciaRepository = agenciaRepository;
        this.contaRepository = contaRepository;
        this.unidadeRepository = unidadeRepository;
        this.empresaService = empresaService;
        this.messageRepository = messageRepository;
        this.contratoRepository = contratoRepository;
        this.servicoRepository = servicoRepository;
        this.situacaoRepository = situacaoRepository;
        this.orientacaoRepository = orientacaoRepository;
        this.recomendacaoRepository = recomendacaoRepository;
        this.config = config;
    }

    @Override
    public RootDTO save(RootDTO dto) {
        Root root = toRoot(dto);
        RootDTO reponse = toRootDto(root);
        return reponse;
    }

    @Override
    public ContaBancariaDTO saveContaBancaria(ContaBancariaDTO contaBancariaDTO) {
        ContaBancaria conta = toContaBancaria(contaBancariaDTO);
        conta = this.contaRepository.save(conta);
        ContaBancariaDTO response = toContaBancariaDTO(conta);
        return response;
    }

    private ContaBancariaDTO toContaBancariaDTO(ContaBancaria conta) {
        return ContaBancariaDTO.builder()
                .id(conta.getId())
                .codAgencia(conta.getAgencia().getCodAgencia())
                .numConta(conta.getNumConta())
                .build();
    }

    @Override
    public BancoDTO saveBanco(BancoDTO dto) {

        Banco banco = toBanco(dto);
        banco = this.bancoRepository.save(banco);
        BancoDTO response = toBancoDTO(banco);
        return response;
    }

    @Override
    public AgenciaBancariaDTO saveAgenciaBancaria(AgenciaBancariaDTO dto) {
        AgenciaBancaria agencia = toAgenciaBancaria(dto);
        agencia = this.agenciaRepository.save(agencia);
        AgenciaBancariaDTO response = toAgenciaBancariaDTO(agencia);
        return response;
    }

    @Override
    public MessageDTO saveMessage(MessageDTO dto) {
        Message message = toMessage(dto);
        message = this.messageRepository.save(message);
        MessageDTO response = toMessageDTO(message);
        return response;
    }

    @Override
    public EmpresaDTO saveEmpresa(EmpresaDTO dto) {
        return this.empresaService.save(dto);
    }

    @Override
    public UnidadeDTO saveUnidadeDeMedida(UnidadeDTO dto) {
        Unidade unidade = toUnidade(dto);
        unidade = this.unidadeRepository.save(unidade);
        return toUnidadeDTO(unidade);
    }

    @Override
    public ContratoDTO criaContrato(ContratoDTO dto) {
        Contrato contrato = toContrato(dto);
        contrato = this.contratoRepository.save(contrato);
        ContratoDTO response = toContratoDTO(contrato);
        return response;
    }

    @Override
    public AppDTO criaApp(AppDTO dto) {
        Root app = toRoot(dto);
        app = this.rootRepository.save(app);
        return toAppDTO(app);
    }

    @Override
    public SituacaoDTO criaSituacao(SituacaoDTO dto) {

        Situacao situacao = toSituacao(dto);

        situacao = this.situacaoRepository.save(situacao);

        return toSituacaoDTO(situacao);
    }

    @Override
    public OrientacaoDTO criaOrientacao(OrientacaoDTO dto) {
        Orientacao orientacao = toOrientacao(dto);
        orientacao = this.orientacaoRepository.save(orientacao);
        OrientacaoDTO response = toOrientacaoDTO(orientacao);
        return response;
    }

    @Override
    public RecomendacaoDTO criaRecomendacao(RecomendacaoDTO dto) {
        Recomendacao recomendacao = toRecomendacao(dto);
        recomendacao = this.recomendacaoRepository.save(recomendacao);
        RecomendacaoDTO reponse = toRecomendacaoFTO(recomendacao);
        return reponse;
    }

    private RecomendacaoDTO toRecomendacaoFTO(Recomendacao recomendacao) {
        List<Integer> servicos = recomendacao.getServicos().stream()
                .map(srv->srv.getId())
                .collect(Collectors.toList());

        return RecomendacaoDTO.builder()
                .id(recomendacao.getId())
                .descricao(recomendacao.getDescricao())
                .codServicos(servicos)
                .build();
    }

    private Recomendacao toRecomendacao(RecomendacaoDTO dto) {
        List<Integer> codServicos = dto.getCodServicos();

        List<Servico> servicos = obterServicos(codServicos);

        return Recomendacao.builder()
                .id(dto.getId())
                .descricao(dto.getDescricao())
                .servicos(servicos)
                .build();
    }

    private Orientacao toOrientacao(OrientacaoDTO dto) {
        List<Integer> codServicos = dto.getCodServicos();

        List<Servico> servicos = obterServicos(codServicos);

        return Orientacao.builder()
                .id(dto.getId())
                .descricao(dto.getDescricao())
                .servicos(servicos)
                .build();

    }

    private OrientacaoDTO toOrientacaoDTO(Orientacao orientacao) {

        List<Integer> servicos = orientacao.getServicos().stream()
                .map(srv->srv.getId())
                .collect(Collectors.toList());

        return OrientacaoDTO.builder()
                .id(orientacao.getId())
                .descricao(orientacao.getDescricao())
                .codServicos(servicos)
                .build();
    }


    private SituacaoDTO toSituacaoDTO(Situacao dto) {

         List<Integer> servicos = dto.getServicos().stream()
                 .map(srv->srv.getId())
                 .collect(Collectors.toList());

        return SituacaoDTO.builder()
                .descricao(dto.getDescricao())
                .id(dto.getId())
                .codServicos(servicos)
                .build();
    }

    private Situacao toSituacao(SituacaoDTO dto) {
        List<Integer> codServicos = dto.getCodServicos();

        List<Servico> servicos = obterServicos(codServicos);

        return Situacao.builder()
                .descricao(dto.getDescricao())
                .id(dto.getId())
                .servicos(servicos)
                .build();
    }

    private List<Servico> obterServicos(List<Integer> codServicos) {
        return codServicos.stream()
                .map(srv->toServicos(srv))
                .filter(srv->srv!=null)
                .collect(Collectors.toList());
    }

    private Orientacao toOrientacao(Integer orient) {
        Optional<Orientacao> orientacao = this.orientacaoRepository.findById(orient);
        if(orientacao.isPresent()){
            return orientacao.get();
        }else {
            return null;
        }
    }

    private Servico toServicos(Integer srv) {
        Optional<Servico> servico = this.servicoRepository.findById(srv);
        if(servico.isPresent()){
            return servico.get();
        }else {
            return null;
        }
    }

    private AppDTO toAppDTO(Root dto) {
        return AppDTO.builder()
                .appDescription(dto.getAppDescription())
                .appKey(dto.getAppKey())
                .appName(dto.getAppName())
                .appVersion(dto.getAppVersion())
                .devFone(dto.getDevFone())
                .devMail(dto.getDevMail())
                .devName(dto.getDevName())
                .build();
    }

    private Root toRoot(AppDTO dto) {
        return Root.builder()
                .appDescription(dto.getAppDescription())
                .appKey(dto.getAppKey())
                .appName(dto.getAppName())
                .appVersion(dto.getAppVersion())
                .devFone(dto.getDevFone())
                .devMail(dto.getDevMail())
                .devName(dto.getDevName())
                .build();
    }

    private ContratoDTO toContratoDTO(Contrato dto) {

        return ContratoDTO.builder()
                .id(dto.getId())
                .clausulas(dto.getClausulas())
                .cnpjContratante(dto.getContratante().getCnpj())
                .fimVigencia(dto.getFimVigencia().format(config.formatterddMMyyyy()))
                .valor(dto.getValor())
                .objeto(dto.getObjeto())
                .servicos(dto.getServicos())
                .remuneracao(dto.getRemuneracao())
                .idApp(dto.getContratado().getAppKey())
                .dataContrato(dto.getDataContrato().format(config.formatterddMMyyyy()))
                .build();
    }

    private Contrato toContrato(ContratoDTO dto) {
        Root root = this.rootRepository.findByAppKey(dto.getIdApp()).orElseThrow(()->new AppNotFoundException());
        Empresa empresa = this.empresaService.findByCnpj(dto.getCnpjContratante());

        LocalDate fim = LocalDate.parse(dto.getFimVigencia(), config.formatterddMMyyyy());

        LocalDate dataContrato = LocalDate.parse(dto.getDataContrato(), config.formatterddMMyyyy());

        LocalTime agora = LocalDateTime.now().toLocalTime();

        return Contrato.builder()
                .id(dto.getId())
                .clausulas(dto.getClausulas())
                .contratado(root)
                .contratante(empresa)
                .fimVigencia(LocalDateTime.of(fim, agora))
                .valor(dto.getValor())
                .objeto(dto.getObjeto())
                .servicos(dto.getServicos())
                .remuneracao(dto.getRemuneracao())
                .dataContrato(LocalDateTime.of(dataContrato, agora))
                .build();
    }

    private UnidadeDTO toUnidadeDTO(Unidade dto) {
        return UnidadeDTO.builder()
                .conv_si(dto.getConv_si())
                .descricao(dto.getDescricao())
                .equiv_si(dto.getEquiv_si())
                .referencia(dto.getReferencia())
                .sigla(dto.getSigla())
                .tipo(dto.getTipo())
                .build();
    }

    private Unidade toUnidade(UnidadeDTO dto) {
        return Unidade.builder()
                .conv_si(dto.getConv_si())
                .descricao(dto.getDescricao())
                .equiv_si(dto.getEquiv_si())
                .referencia(dto.getReferencia())
                .sigla(dto.getSigla())
                .tipo(dto.getTipo())
                .build();
    }

    private MessageDTO toMessageDTO(Message dto) {
        return MessageDTO.builder()
                .description(dto.getDescription())
                .codEmpresa(dto.getEmpresa().getId())
                .id(dto.getId())
                .message(dto.getMessage())
                .visivel(dto.getVisivel())
                .build();
    }

    private Message toMessage(MessageDTO dto) {
        Empresa empresa = this.empresaService.findById(dto.getCodEmpresa());
        return Message.builder()
                .description(dto.getDescription())
                .empresa(empresa)
                .id(dto.getId())
                .message(dto.getMessage())
                .visivel(dto.getVisivel())
                .build();
    }

    private AgenciaBancariaDTO toAgenciaBancariaDTO(AgenciaBancaria agencia) {

        return AgenciaBancariaDTO.builder()
                .codBanco(agencia.getBanco().getCodigoDoBanco())
                .codAgencia(agencia.getCodAgencia())
                .codIBGEMunicipio(agencia.getCodIBGEMunicipio())
                .emailAgencia(agencia.getEmailAgencia())
                .enderecoAgencia(agencia.getEnderecoAgencia())
                .foneAgencia(agencia.getFoneAgencia())
                .foneGerente(agencia.getFoneGerente())
                .NomeAgencia(agencia.getNomeAgencia())
                .nomeGerente(agencia.getNomeGerente())
                .build();
    }

    private AgenciaBancaria toAgenciaBancaria(AgenciaBancariaDTO dto) {
        Banco banco = this.bancoRepository.findByCodigoDoBanco(dto.getCodBanco()).orElseThrow(()->new BancoNotFoundException());
        return AgenciaBancaria.builder()
                .banco(banco)
                .codAgencia(dto.getCodAgencia())
                .codIBGEMunicipio(dto.getCodIBGEMunicipio())
                .emailAgencia(dto.getEmailAgencia())
                .enderecoAgencia(dto.getEnderecoAgencia())
                .foneAgencia(dto.getFoneAgencia())
                .foneGerente(dto.getFoneGerente())
                .NomeAgencia(dto.getNomeAgencia())
                .nomeGerente(dto.getNomeGerente())
                .build();
    }

    private BancoDTO toBancoDTO(Banco banco) {
        return BancoDTO.builder()
                .codigoDoBanco(banco.getCodigoDoBanco())
                .nome(banco.getNome())
                .sigla(banco.getSigla())
                .build();
    }

    private Banco toBanco(BancoDTO dto) {
        return Banco.builder()
                .codigoDoBanco(dto.getCodigoDoBanco())
                .nome(dto.getNome())
                .sigla(dto.getSigla())
                .build();
    }

    private ContaBancaria toContaBancaria(ContaBancariaDTO contaBancariaDTO) {
        AgenciaBancaria agencia = agenciaRepository.findByCodAgencia(contaBancariaDTO.getCodAgencia());
        return ContaBancaria.builder()
                .id(contaBancariaDTO.getId())
                .agencia(agencia)
                .numConta(contaBancariaDTO.getNumConta())
                .build();
    }

    private RootDTO toRootDto(Root root) {
        RootDTO response = new RootDTO();
        response.setAppName(root.getAppName());
        response.setAppDescription(root.getAppDescription());
        response.setAppVersion(root.getAppVersion());
        response.setDevFone(root.getDevFone());
        response.setDevMail(root.getDevMail());
        response.setDevName(root.getDevName());
        return response;
    }

    private Root toRoot(RootDTO dto) {
        Root response = new Root();
        response.setAppName(dto.getAppName());
        response.setAppDescription(dto.getAppDescription());
        response.setAppVersion(dto.getAppVersion());
        response.setDevFone(dto.getDevFone());
        response.setDevMail(dto.getDevMail());
        response.setDevName(dto.getDevName());
        return response;
    }
}
