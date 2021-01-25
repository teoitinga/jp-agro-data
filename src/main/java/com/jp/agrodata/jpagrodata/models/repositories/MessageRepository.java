package com.jp.agrodata.jpagrodata.models.repositories;

import com.jp.agrodata.jpagrodata.models.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {
}
