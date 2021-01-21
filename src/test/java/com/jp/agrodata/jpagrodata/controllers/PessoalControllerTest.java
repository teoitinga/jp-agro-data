package com.jp.agrodata.jpagrodata.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jp.agrodata.jpagrodata.dtos.ClienteDTO;
import com.jp.agrodata.jpagrodata.dtos.ProjetoDTO;
import com.jp.agrodata.jpagrodata.factories.ClienteDTOFactory;
import com.jp.agrodata.jpagrodata.factories.ProjetoDTOFactory;
import com.jp.agrodata.jpagrodata.services.PessoaService;
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

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@WebMvcTest(controllers = PessoalController.class)
@AutoConfigureMockMvc
class PessoalControllerTest {
    static String ROOT_APP = "/api/v1/pessoas";

    @Autowired
    MockMvc mvc;

    @MockBean
    PessoaService pessoaService;
    @Test
    @DisplayName("Deve inserir registro de novo cliente")
    void registrar()  throws Exception {
        ClienteDTO dto = ClienteDTOFactory.registraDTOValido();
        ClienteDTO saved = ClienteDTOFactory.registraDTOValidoComID();

        String json = new ObjectMapper().writeValueAsString(dto);
        BDDMockito.given(pessoaService.save(Mockito.any(ClienteDTO.class))).willReturn(saved);
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(ROOT_APP)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json);

        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("id").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("nome").value("José"))
        ;
    }
}