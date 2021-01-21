package com.jp.agrodata.jpagrodata.models.repositories;

import com.jp.agrodata.jpagrodata.models.entities.ClientePF;
import com.jp.agrodata.jpagrodata.models.entities.ClientePJ;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientePFRepository extends JpaRepository<ClientePF, Long> {
}
