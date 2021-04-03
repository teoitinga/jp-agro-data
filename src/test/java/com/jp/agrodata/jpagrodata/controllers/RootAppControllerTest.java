package com.jp.agrodata.jpagrodata.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jp.agrodata.jpagrodata.dtos.ContratoDto;
import com.jp.agrodata.jpagrodata.dtos.EmpresaDTO;
import com.jp.agrodata.jpagrodata.factories.ContratoFactory;
import com.jp.agrodata.jpagrodata.factories.EmpresaFactory;
import com.jp.agrodata.jpagrodata.services.ContratoService;
import com.jp.agrodata.jpagrodata.services.EmpresaService;
import com.jp.agrodata.jpagrodata.services.MunicipioService;
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
    private EmpresaService empresaService;

    @MockBean
    private ContratoService contratoService;

    @MockBean
    private MunicipioService municipioService;

    @Test
    @DisplayName("Deve inserir registro de nova empresa")
    public void registraEmpresaTest() throws Exception {

        EmpresaDTO dto = EmpresaFactory.criaEmpresaPmItingaDTOValida();
        EmpresaDTO empresaSaved = EmpresaFactory.criaEmpresaEslocDTOSaved();

        BDDMockito.given(empresaService.save(Mockito.any(EmpresaDTO.class))).willReturn(empresaSaved);

        String json = new ObjectMapper().writeValueAsString(dto);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(ROOT_APP.concat("/empresa/"))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json);

        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("id").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("nomeFantasia").value("Escritório local da Tarumirim - EMATER/MG"))
                .andExpect(MockMvcResultMatchers.jsonPath("cnpj").value("3680491000017"))
                ;
    }


    @Test
    @DisplayName("Deve obter os dados da empresa registrada através do ID informado")
    public void getEmpresaTest() throws Exception {

        //Código da empresa testada
        Integer codigo = 229;

        EmpresaDTO empresaGeted = EmpresaFactory.criaEmpresaEslocDTOSaved();

        BDDMockito.given(empresaService.obterEmpresa(Mockito.any(Integer.class))).willReturn(empresaGeted);

         MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(ROOT_APP.concat("/empresa/"))
                .param("id", String.valueOf(codigo))
                .accept(MediaType.APPLICATION_JSON)
                 ;

        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("id").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("nomeFantasia").value("Escritório local da Tarumirim - EMATER/MG"))
                .andExpect(MockMvcResultMatchers.jsonPath("cnpj").value("3680491000017"))
        ;
    }

    @Test
    @DisplayName("Deve criar registro de contrato.")
    public void criaContratoTest() throws Exception {

        //ContratoDto contrato = ContratoFactory.contratoDto();
        ContratoDto contratoSaved = ContratoFactory.contratoDto();

        BDDMockito.given(contratoService.save(Mockito.any(ContratoDto.class))).willReturn(contratoSaved);

        String json = new ObjectMapper().writeValueAsString(contratoSaved);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(ROOT_APP.concat("/contrato/"))
                 .contentType(MediaType.APPLICATION_JSON)
                 .accept(MediaType.APPLICATION_JSON)
                 .content(json);
                 ;

        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("id").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("objeto").value("Acesso a sistema de gerenciamento de informações"))
        ;
    }

}
