package com.jp.agrodata.jpagrodata.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class AppInfo {

    @Column(name="APP_VERSION_T10", length = 10, nullable=false, unique = false)
    private String appVersion;

    @Column(name="APP_NAME_T15", length = 15, nullable=false, unique = false)
    private String appName;

    @Column(name="APP_KEY_T15", length = 15, nullable=false, unique = false)
    private String appKey;

    @Column(name="APP_DESCRIPTION_T259", length = 250, nullable=false, unique = false)
    private String appDescription;

}
