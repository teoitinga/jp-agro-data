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

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "appVersion", column = @Column(name = "APP_VERSION_T10")),
            @AttributeOverride( name = "appName", column = @Column(name = "APP_NAME_T15")),
            @AttributeOverride( name = "appKey", column = @Column(name = "APP_KEY_T15")),
            @AttributeOverride( name = "appDescription", column = @Column(name = "APP_DESCRIPTION_T259"))
    })
    private AppInfo appinfo;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "appVersion", column = @Column(name = "APP_VERSION_T10")),
            @AttributeOverride( name = "devName", column = @Column(name = "DEV_NAME_T250")),
            @AttributeOverride( name = "devMail", column = @Column(name = "DEV_MAIL_T50")),
            @AttributeOverride( name = "devFone", column = @Column(name = "DEV_FONE_T50"))
    })
    private Developer desenvolvedor;

    @OneToMany(mappedBy = "empresa")
    private List<Message> messages;

    @OneToMany(mappedBy = "empresa")
    private List<ContaBancaria> devConta;

}
