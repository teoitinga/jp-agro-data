package com.jp.agrodata.jpagrodata.models.repositories;

import com.jp.agrodata.jpagrodata.models.entities.AgenciaBancaria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgenciaBancariaRepository extends JpaRepository<AgenciaBancaria, String> {
    AgenciaBancaria findByCodAgencia(String codAgencia);
}
