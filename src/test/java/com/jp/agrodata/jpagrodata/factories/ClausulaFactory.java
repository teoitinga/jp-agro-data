package com.jp.agrodata.jpagrodata.factories;

import com.jp.agrodata.jpagrodata.dtos.ClausulaDto;

import java.util.ArrayList;
import java.util.List;

public class ClausulaFactory {

    public static List<ClausulaDto> clausulas() {

        List<ClausulaDto> clausulas = new ArrayList<>();

        clausulas.add(clausula01());
        clausulas.add(clausula02());

        return clausulas;
    }

    private static ClausulaDto clausula01() {
        String cls = " O presente contrato tem por objetivo o desenvolvimento de site, software e aplicativo Hibrido. ";
        return ClausulaDto.builder()
                .description(cls)
                .build();
    }

    private static ClausulaDto clausula02() {
        String cls = "Serão de propriedade da CONTRATANTE todos os programas, módulos, manuais, documentação associada e sistemas, resultantes deste contrato, sendo proibido seu uso ou comercialização pela CONTRATADA.";

        return ClausulaDto.builder()
                .description(cls)
                .build();
    }
}
