package com.jp.agrodata.jpagrodata.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "TAB_MUNICIPIO")
public class Municipio  implements Serializable {

    @Id
    private String codigo_ibge;

    @Column(name = "MUNICIPIO", nullable = false)
    private String municipio;

    @Column(name = "UF", nullable = false)
    private String uf;

}
