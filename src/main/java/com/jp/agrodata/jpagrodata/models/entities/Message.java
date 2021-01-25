package com.jp.agrodata.jpagrodata.models.entities;

import com.jp.agrodata.jpagrodata.models.enums.EnumSimNao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "TAB_MESSAGE")
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="MESSAGE", nullable=false)
    @Lob
    private String message;

    @Column(name="DESCRIPTION", nullable=false)
    @Lob
    private String description;

    @ManyToOne
    @JoinColumn(name = "COD_EMPRESA")
    private Empresa empresa;

    @Enumerated(EnumType.STRING)
    private EnumSimNao visivel;

}
