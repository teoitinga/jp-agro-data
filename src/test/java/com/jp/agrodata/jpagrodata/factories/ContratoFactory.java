package com.jp.agrodata.jpagrodata.factories;

import com.jp.agrodata.jpagrodata.dtos.ContratoDto;

import java.time.LocalDateTime;

public class ContratoFactory {
    public static ContratoDto contratoDto() {
        return ContratoDto.builder()
                .codContratado("1")
                .codContratante("1")
                .dataContrato("21/05/2019")
                .objeto("Acesso a sistema de gerenciamento de informações")
                .build();
    }
    public static ContratoDto contratoSavedDto() {
        return ContratoDto.builder()
                .id(1)
                .codContratado("1")
                .codContratante("1")
                .dataContrato("21/05/2019")
                .objeto("Acesso a sistema de gerenciamento de informações")
                .build();
    }

    public static ContratoDto contratoEslocDto() {
        return ContratoDto.builder()
                .codContratado("1")
                .codContratante("1")
                .dataContrato("21/05/2019")
                .objeto("Acesso a sistema de gerenciamento de informações")
                .build();
    }
}
