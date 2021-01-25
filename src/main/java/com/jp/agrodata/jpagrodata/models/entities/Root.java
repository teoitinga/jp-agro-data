package com.jp.agrodata.jpagrodata.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TAB_ROOT")
public class Root implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", nullable=false, unique = true)
    private Integer id;

    @Column(name="APP_NAME_T15", length = 15, nullable=false, unique = false)
    private String appName;

    @Column(name="APP_KEY_T15", length = 15, nullable=false, unique = false)
    private String appKey;

    @Column(name="APP_DESCRIPTION_T259", length = 250, nullable=false, unique = false)
    private String appDescription;

    @Column(name="APP_VERSION_T10", length = 10, nullable=false, unique = false)
    private String appVersion;

    @Column(name="DEV_NAME_T250", length = 250, nullable=false, unique = false)
    private String devName;

    @Column(name="DEV_MAIL_T50", length = 50, nullable=false, unique = false)
    private String devMail;

    @Column(name="DEV_FONE_T50", length = 50, nullable=false, unique = false)
    private String devFone;

    @OneToMany(mappedBy = "empresa")
    private List<Message> messages;

    @OneToMany(mappedBy = "empresa")
    private List<ContaBancaria> devConta;

}
