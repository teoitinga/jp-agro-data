package com.jp.agrodata.jpagrodata.models.embeddeds;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Developer implements Serializable {

    @Column(name="DEV_NAME_T250", length = 250, nullable=false, unique = false)
    private String devName;

    @Column(name="DEV_MAIL_T50", length = 50, nullable=false, unique = false)
    private String devMail;

    @Column(name="DEV_FONE_T50", length = 50, nullable=false, unique = false)
    private String devFone;
}
