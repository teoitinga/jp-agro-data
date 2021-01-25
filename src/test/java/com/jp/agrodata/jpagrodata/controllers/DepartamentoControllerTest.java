package com.jp.agrodata.jpagrodata.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jp.agrodata.jpagrodata.dtos.DepartamentoDTO;
import com.jp.agrodata.jpagrodata.dtos.ProjetoDTO;
import com.jp.agrodata.jpagrodata.factories.DepartamentoDTOFactory;
import com.jp.agrodata.jpagrodata.services.DepartamentoService;
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
@WebMvcTest(controllers = DepartamentoController.class)
@AutoConfigureMockMvc
class DepartamentoControllerTest {

    static String ROOT_APP = "/api/v1/departamento";

    @Autowired
    MockMvc mvc;

    @MockBean
    DepartamentoService departamentoService;


}