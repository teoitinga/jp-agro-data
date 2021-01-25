package com.jp.agrodata.jpagrodata.models.repositories;

import com.jp.agrodata.jpagrodata.models.entities.Banco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BancoRepository extends JpaRepository<Banco, String> {
    Optional<Banco> findByCodigoDoBanco(String codBanco);
}
