package com.jp.agrodata.jpagrodata.dtos;

import com.jp.agrodata.jpagrodata.models.enums.EnumSimNao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageDTO implements Serializable {

    private Integer id;
    private String message;
    private String description;

    private Integer codEmpresa;

    private EnumSimNao visivel;
}
