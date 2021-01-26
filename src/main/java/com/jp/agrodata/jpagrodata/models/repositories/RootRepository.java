package com.jp.agrodata.jpagrodata.models.repositories;

import com.jp.agrodata.jpagrodata.models.entities.Root;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RootRepository extends JpaRepository<Root, Integer> {
    @Query(value = "SELECT r FROM Root r WHERE r.appinfo.appKey = :appKey")
    Optional<Root> findByAppKey(@Param("appKey") String appKey);
}
