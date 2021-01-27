package com.jp.agrodata.jpagrodata.models.embeddeds;

import com.jp.agrodata.jpagrodata.models.entities.Usuario;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Auditable {

    private LocalDateTime created;

    private LocalDateTime updated;

    @ManyToOne
    @JoinColumn(name = "CREATED_USER_ID")
    private Usuario userCreated;

    @ManyToOne
    @JoinColumn(name = "UPDATED_USER_ID")
    private Usuario userUpdated;


}
