package com.jp.agrodata.jpagrodata.factories;

import com.jp.agrodata.jpagrodata.dtos.MunicipioDto;

public class MunicipioFactory {
    public static MunicipioDto TarumirimDto() {
        return MunicipioDto.builder()
                .municipio("Tarumirim")
                .uf("MG")
                .build();
    }
    public static MunicipioDto TarumirimSavedDto() {
        return MunicipioDto.builder()
                .id("H0684")
                .municipio("Tarumirim")
                .uf("MG")
                .build();
    }

    public static MunicipioDto ItingaDto() {
        return MunicipioDto.builder()
                .municipio("Itinga")
                .uf("MG")
                .build();
    }

    public static MunicipioDto ConsPenaDto() {
        return MunicipioDto.builder()
                .municipio("Conselheiro Pena")
                .uf("MG")
                .build();
    }
}
