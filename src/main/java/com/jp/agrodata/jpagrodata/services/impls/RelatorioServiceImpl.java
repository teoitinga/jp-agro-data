package com.jp.agrodata.jpagrodata.services.impls;

import com.jp.agrodata.jpagrodata.dtos.SituacaoDTO;
import com.jp.agrodata.jpagrodata.models.entities.Servico;
import com.jp.agrodata.jpagrodata.models.entities.Situacao;
import com.jp.agrodata.jpagrodata.models.repositories.ServicoRepository;
import com.jp.agrodata.jpagrodata.models.repositories.SituacaoRepository;
import com.jp.agrodata.jpagrodata.services.RelatorioService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RelatorioServiceImpl implements RelatorioService {

    private SituacaoRepository situacaoRepository;
    private ServicoRepository servicoRepository;

    public RelatorioServiceImpl(
            SituacaoRepository situacaoRepository,
                                ServicoRepository servicoRepository
    ) {
        this.situacaoRepository = situacaoRepository;
        this.servicoRepository = servicoRepository;
    }

    @Override
    public Page<SituacaoDTO> obterSituacaoPorServico(String servico, Pageable pageRequest) {
        Optional<Servico> srv = this.servicoRepository.findById(Integer.parseInt(servico));
        Page<Situacao> result = this.situacaoRepository.findByServicoContainingIgnoreCase(srv.get(), pageRequest);

        List<SituacaoDTO> list =result.getContent().stream()
                .map(entity->toSituacaoDTO(entity))
                .collect(Collectors.toList());
        return new PageImpl<>(list, pageRequest, result.getTotalElements());
    }

    private SituacaoDTO toSituacaoDTO(Situacao entity) {
        return SituacaoDTO.builder()
                .id(entity.getId())
                .descricao(entity.getDescricao())
                .codServicos(toCodServico(entity.getServicos()))
                .build();
    }

    private List<Integer> toCodServico(List<Servico> servicos) {
        return servicos.stream()
                .map(srv->srv.getId())
                .collect(Collectors.toList());
    }
}
