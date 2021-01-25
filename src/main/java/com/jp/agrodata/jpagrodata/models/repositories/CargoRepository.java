package com.jp.agrodata.jpagrodata.models.repositories;

import com.jp.agrodata.jpagrodata.models.entities.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<Cargo, Integer> {
}
