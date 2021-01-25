package com.jp.agrodata.jpagrodata.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RootDTO {
    private String appName;
    private String appDescription;
    private String appVersion;
    private String devName;
    private String devMail;
    private String devFone;
    }
