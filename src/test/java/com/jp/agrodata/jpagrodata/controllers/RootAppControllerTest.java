package com.jp.agrodata.jpagrodata.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jp.agrodata.jpagrodata.dtos.EmpresaDTO;
import com.jp.agrodata.jpagrodata.factories.EmpresaDTOFactory;
import com.jp.agrodata.jpagrodata.services.EmpresaService;
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
@WebMvcTest(controllers = RootAppController.class)
@AutoConfigureMockMvc
public class RootAppControllerTest {

    static String ROOT_APP = "/api/v1/root";

    @Autowired
    MockMvc mvc;

    @MockBean
    EmpresaService empresaService;

    @Test
    @DisplayName("Deve inserir registro de nova empresa")
    public void criarEmpresaTest() throws Exception {

        EmpresaDTO dto = EmpresaDTOFactory.criaEmpresaDTOValida();
        EmpresaDTO empresaSaved = EmpresaDTOFactory.criaEmpresaDTOValidaComID();

        BDDMockito.given(empresaService.save(Mockito.any(EmpresaDTO.class))).willReturn(empresaSaved);

        String json = new ObjectMapper().writeValueAsString(dto);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(ROOT_APP)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json);

        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("id").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("nomeFantasia").value("Escritório local da Tarumirim - EMATER/MG"))
                .andExpect(MockMvcResultMatchers.jsonPath("dataAtivacao").value("15/01/2021"))
                ;
    }
    @Test
    @DisplayName("Deve lancar erro ao inserir registro de nova empresa")
    public void criarEmpresaInvalidaTest(){

    }
}
