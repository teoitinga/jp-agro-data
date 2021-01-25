package com.jp.agrodata.jpagrodata.models.repositories;

import com.jp.agrodata.jpagrodata.models.entities.Root;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RootRepository extends JpaRepository<Root, Integer> {
    Optional<Root> findByAppKey(String appKey);
}
