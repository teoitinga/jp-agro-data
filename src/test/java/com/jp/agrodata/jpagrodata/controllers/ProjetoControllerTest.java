package com.jp.agrodata.jpagrodata.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jp.agrodata.jpagrodata.dtos.EmpresaDTO;
import com.jp.agrodata.jpagrodata.dtos.ProjetoDTO;
import com.jp.agrodata.jpagrodata.factories.EmpresaDTOFactory;
import com.jp.agrodata.jpagrodata.factories.ProjetoDTOFactory;
import com.jp.agrodata.jpagrodata.services.ProjetoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@WebMvcTest(controllers = ProjetoController.class)
@AutoConfigureMockMvc
class ProjetoControllerTest {

    static String ROOT_APP = "/api/v1/projetos";

    @Autowired
    MockMvc mvc;

    @MockBean
    ProjetoService projetoService;

    @Test
    @DisplayName("Deve inserir registro de novo projeto")
    void criaProjeto() throws Exception {

        ProjetoDTO dto = ProjetoDTOFactory.criaDTOValido();
        ProjetoDTO saved = ProjetoDTOFactory.criaDTOValidoComID();

        String json = new ObjectMapper().writeValueAsString(dto);
        BDDMockito.given(projetoService.save(Mockito.any(ProjetoDTO.class))).willReturn(saved);
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(ROOT_APP)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json);

        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("id").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("nomeDoProjeto").value("Boa horta"))
        ;
    }
}