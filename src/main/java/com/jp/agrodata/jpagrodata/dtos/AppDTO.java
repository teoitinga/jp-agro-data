package com.jp.agrodata.jpagrodata.dtos;

import com.jp.agrodata.jpagrodata.models.entities.ContaBancaria;
import com.jp.agrodata.jpagrodata.models.entities.Message;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppDTO implements Serializable {

    private Integer id;

    private String appName;

    private String appKey;

    private String appDescription;

    private String appVersion;

    private String devName;

    private String devMail;

    private String devFone;

}
