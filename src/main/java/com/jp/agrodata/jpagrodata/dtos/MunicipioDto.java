package com.jp.agrodata.jpagrodata.dtos;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class MunicipioDto implements Serializable {

    private String id;

    private String municipio;

    private String uf;
}
