package com.jp.agrodata.jpagrodata.models.repositories;

import com.jp.agrodata.jpagrodata.models.entities.Servico;
import com.jp.agrodata.jpagrodata.models.entities.Situacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SituacaoRepository extends JpaRepository<Situacao, Integer> {
    @Query("select s from Situacao s where (s.servicos = :servico)")
    Page<Situacao> findByServicoContainingIgnoreCase(Servico servico, Pageable pageRequest);
}
