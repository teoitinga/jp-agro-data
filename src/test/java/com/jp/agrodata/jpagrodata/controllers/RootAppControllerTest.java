package com.jp.agrodata.jpagrodata.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jp.agrodata.jpagrodata.dtos.*;
import com.jp.agrodata.jpagrodata.factories.*;
import com.jp.agrodata.jpagrodata.services.*;
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

    @MockBean
    private BancoService bancoService;

    @MockBean
    private ClSetoresService clSetoresService;

    @MockBean
    private UnidadeService unidadeService;

    /*
     * Registros de Dados da Empresa
     * */

    @Test
    @DisplayName("Deve registrar uma nova empresa")
    public void criaEmpresaTest() throws Exception {

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
                .andExpect(MockMvcResultMatchers.jsonPath("cnpj").value("81385256000166"))
                .andExpect(MockMvcResultMatchers.jsonPath("cpfRepresentante").value("31558089004"))
                .andExpect(MockMvcResultMatchers.jsonPath("cpfVendedor").value("86267293084"))
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
                .andExpect(MockMvcResultMatchers.jsonPath("cnpj").value("81385256000166"))
                .andExpect(MockMvcResultMatchers.jsonPath("cpfRepresentante").value("31558089004"))
                .andExpect(MockMvcResultMatchers.jsonPath("cpfVendedor").value("86267293084"))
        ;
    }
    @Test
    @DisplayName("Deve atualizar os dados da empresa registrada através do ID informado")
    public void updateEmpresaTest() throws Exception {

        //Código da empresa testada
        Integer codigo = 229;

        EmpresaDTO empresaGeted = EmpresaFactory.criaEmpresaEslocDTOSaved();

        BDDMockito.given(empresaService.update(Mockito.any(EmpresaDTO.class), Mockito.any(String.class))).willReturn(empresaGeted);

        String json = new ObjectMapper().writeValueAsString(empresaGeted);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.put(ROOT_APP.concat("/empresa"))
                .param("id", String.valueOf(codigo))
                .content(json)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                ;

        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("id").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("nomeFantasia").value("Escritório local da Tarumirim - EMATER/MG"))
                .andExpect(MockMvcResultMatchers.jsonPath("cnpj").value("81385256000166"))
        ;
    }
    /*
     * Registros de Dados do Contrato
     * */
    @Test
    @DisplayName("Deve criar registro de contrato.")
    public void criaContratoTest() throws Exception {

        ContratoDto contratoSaved = ContratoFactory.contratoSavedDto();

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
    @Test
    @DisplayName("Deve obter os dados do contrato da empresa registrada através do ID informado")
    public void getContratoTest() throws Exception {

        //Código do contrato testada
        Integer codigo = 229;

        ContratoDto contratoGeted = ContratoFactory.contratoSavedDto();

        BDDMockito.given(contratoService.getContrato(Mockito.any(Integer.class))).willReturn(contratoGeted);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(ROOT_APP.concat("/contrato/"))
                .param("id", String.valueOf(codigo))
                .accept(MediaType.APPLICATION_JSON)
                ;

        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("id").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("objeto").value("Acesso a sistema de gerenciamento de informações"))
        ;
    }

    /*
    * Registros de Dados do Município
    * */

    @Test
    @DisplayName("Deve criar registro do Município.")
    public void criaMunicipioTest() throws Exception {

        MunicipioDto municipioDto = MunicipioFactory.TarumirimSavedDto();

        BDDMockito.given(municipioService.save(Mockito.any(MunicipioDto.class))).willReturn(municipioDto);

        String json = new ObjectMapper().writeValueAsString(municipioDto);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(ROOT_APP.concat("/municipio/"))
                 .contentType(MediaType.APPLICATION_JSON)
                 .accept(MediaType.APPLICATION_JSON)
                 .content(json);
                 ;

        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("id").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("municipio").value("Tarumirim"))
        ;
    }
    @Test
    @DisplayName("Deve obter os dados do contrato da empresa registrada através do ID informado")
    public void getMunicipioTest() throws Exception {

        //Código do contrato testada
        String codigo = "229";

        MunicipioDto municipioDto = MunicipioFactory.TarumirimSavedDto();

        BDDMockito.given(municipioService.getMunicipio(Mockito.any(String.class))).willReturn(municipioDto);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(ROOT_APP.concat("/municipio/"))
                .param("id", String.valueOf(codigo))
                .accept(MediaType.APPLICATION_JSON)
                ;

        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("id").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("municipio").value("Tarumirim"))
        ;
    }

    /*
     * Registros de Dados do Plano
     * */

    @Test
    @DisplayName("Deve criar registro do plano.")
    public void criaPlanoTest() throws Exception {

        PlanoDto planoSaved = PlanoFactory.planoPadraoSavedDto();

        BDDMockito.given(contratoService.savePlano(Mockito.any(PlanoDto.class))).willReturn(planoSaved);

        String json = new ObjectMapper().writeValueAsString(planoSaved);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(ROOT_APP.concat("/contrato/plano/"))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json);
        ;

        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("id").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("qtd_departamento").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("qtd_projeto").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("qtd_acao").value(5))
                .andExpect(MockMvcResultMatchers.jsonPath("qtd_meta").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("qtd_funcionario").value(4))
                .andExpect(MockMvcResultMatchers.jsonPath("valor_contrato").value(998.35))
        ;
    }
    @Test
    @DisplayName("Deve obter os dados do plano contratado através do ID informado")
    public void getPlanoTest() throws Exception {

        //Código do contrato testada
        String codigo = "229";

        PlanoDto planoDto = PlanoFactory.planoPadraoSavedDto();

        BDDMockito.given(contratoService.getPlano(Mockito.any(Integer.class))).willReturn(planoDto);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(ROOT_APP.concat("/contrato/plano/"))
                .param("id", String.valueOf(codigo))
                .accept(MediaType.APPLICATION_JSON)
                ;

        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("id").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("qtd_departamento").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("qtd_projeto").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("qtd_acao").value(5))
                .andExpect(MockMvcResultMatchers.jsonPath("qtd_meta").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("qtd_funcionario").value(4))
                .andExpect(MockMvcResultMatchers.jsonPath("valor_contrato").value(998.35))
        ;
    }

    /*
     * Registros de Dados da Clausula
     * */

    @Test
    @DisplayName("Deve criar registro da Cláusula.")
    public void criaClausulaTest() throws Exception {

        ClausulaDto savedDto = ClausulaFactory.clausula01SavedDto();

        BDDMockito.given(contratoService.saveClausula(Mockito.any(ClausulaDto.class))).willReturn(savedDto);

        String json = new ObjectMapper().writeValueAsString(savedDto);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(ROOT_APP.concat("/contrato/clausula/"))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json);
        ;

        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("id").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("numero").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("description").value("O presente contrato tem por objetivo o desenvolvimento de site, software e aplicativo Hibrido."))
        ;
    }
    @Test
    @DisplayName("Deve obter os dados do contrato da empresa registrada através do ID informado")
    public void getClausulaTest() throws Exception {

        //Código do contrato testada
        String codigo = "229";

        ClausulaDto clausulaDto = ClausulaFactory.clausula01SavedDto();

        BDDMockito.given(contratoService.getClausula(Mockito.any(Integer.class))).willReturn(clausulaDto);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(ROOT_APP.concat("/contrato/clausula/"))
                .param("id", String.valueOf(codigo))
                .accept(MediaType.APPLICATION_JSON)
                ;

        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("id").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("numero").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("description").value("O presente contrato tem por objetivo o desenvolvimento de site, software e aplicativo Hibrido."))
        ;
    }
    /*
      Registro de Bancos

    */
    @Test
    @DisplayName("Deve criar registro de um Banco.")
    public void criaBancoTest() throws Exception {

        BancoDto savedDto = BancoFactory.bancoBbDto();

        BDDMockito.given(bancoService.saveBanco(Mockito.any(BancoDto.class))).willReturn(savedDto);

        String json = new ObjectMapper().writeValueAsString(savedDto);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(ROOT_APP.concat("/banco/"))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json);
        ;

        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("codigoDoBanco").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("nome").value("Banco do Brasil"))
        ;
    }
    @Test
    @DisplayName("Deve obter os dados do Banco através do ID informado")
    public void getBancoTest() throws Exception {

        //Código do Banco testado
        String codigo = "229";

        BancoDto bancoDto = BancoFactory.bancoSicoobDto();

        BDDMockito.given(bancoService.getBanco(Mockito.any(String.class))).willReturn(bancoDto);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(ROOT_APP.concat("/banco/"))
                .param("id", String.valueOf(codigo))
                .accept(MediaType.APPLICATION_JSON)
                ;

        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("codigoDoBanco").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("nome").value("Banco Sicoob"))
        ;
    }

    /*
    Registro da Agências bancárias

     */
    @Test
    @DisplayName("Deve criar registro da Agência Bancária.")
    public void criaAgenciaBancariaTest() throws Exception {

        AgenciaBancariaDto savedDto = AgenciaBancariaFactory.agenciaBbDto();

        BDDMockito.given(bancoService.saveAgencia(Mockito.any(AgenciaBancariaDto.class))).willReturn(savedDto);

        String json = new ObjectMapper().writeValueAsString(savedDto);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(ROOT_APP.concat("/agenciabancaria/"))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json);
        ;

        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("codAgencia").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("nomeAgencia").value("Ag. Ibituruna"))
        ;
    }
    @Test
    @DisplayName("Deve obter os dados da agencia bancária através do ID informado")
    public void getAgenciaBancariaTest() throws Exception {

        //Código do contrato testada
        String codigo = "229";

        AgenciaBancariaDto bancoDto = AgenciaBancariaFactory.agenciaBbDto();

        BDDMockito.given(bancoService.getAgencia(Mockito.any(String.class))).willReturn(bancoDto);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(ROOT_APP.concat("/agenciabancaria/"))
                .param("id", String.valueOf(codigo))
                .accept(MediaType.APPLICATION_JSON)
                ;

        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("codAgencia").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("nomeAgencia").value("Ag. Ibituruna"))
        ;
    }

    /*
    Registro da Contas bancárias

     */
    @Test
    @DisplayName("Deve criar registro da Conta Bancária.")
    public void criaContaBancariaTest() throws Exception {

        ContaBancariaDto savedDto = ContaBancariaFactory.contaCorrenteSavedDto();

        BDDMockito.given(bancoService.saveConta(Mockito.any(ContaBancariaDto.class))).willReturn(savedDto);

        String json = new ObjectMapper().writeValueAsString(savedDto);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(ROOT_APP.concat("/contabancaria/"))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json);
        ;

        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("codAgencia").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("numConta").value("20.960-0"))
        ;
    }
    @Test
    @DisplayName("Deve obter os dados da conta bancária através do ID informado")
    public void getContaBancariaTest() throws Exception {

        //Código do contrato testada
        String codigo = "229";

        ContaBancariaDto conta = ContaBancariaFactory.contaCorrenteSavedDto();

        BDDMockito.given(bancoService.getConta(Mockito.any(String.class))).willReturn(conta);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(ROOT_APP.concat("/contabancaria/"))
                .param("id", String.valueOf(codigo))
                .accept(MediaType.APPLICATION_JSON)
                ;

        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("codAgencia").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("numConta").value("20.960-0"))
        ;
    }

    /*
    Registro da Classes de Setores

     */
    @Test
    @DisplayName("Deve criar registro da Classe de setores.")
    public void criaSetorClassTest() throws Exception {

        SetorClassDto savedDto = SetorClassFactory.agricultura();

        BDDMockito.given(clSetoresService.save(Mockito.any(SetorClassDto.class))).willReturn(savedDto);

        String json = new ObjectMapper().writeValueAsString(savedDto);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(ROOT_APP.concat("/clsetores/"))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json);
        ;

        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("nome").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("nome").value("Agricultura"))
        ;
    }
    @Test
    @DisplayName("Deve obter os dados da Classe de setores através do ID informado")
    public void getSetorClassTest() throws Exception {

        //Código do contrato testada
        String codigo = "229";

        SetorClassDto dto = SetorClassFactory.educacao();

        BDDMockito.given(clSetoresService.getById(Mockito.any(String.class))).willReturn(dto);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(ROOT_APP.concat("/clsetores/"))
                .param("id", String.valueOf(codigo))
                .accept(MediaType.APPLICATION_JSON)
                ;

        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("nome").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("nome").value("educação"))
        ;
    }

    /*
    Registro da Unidades de medida

     */
    @Test
    @DisplayName("Deve criar registro da Unidades de medida.")
    public void criaUnidadeTest() throws Exception {

        UnidadeDto savedDto = UnidadeMedidaFactory.linearMetroDto();

        BDDMockito.given(unidadeService.save(Mockito.any(UnidadeDto.class))).willReturn(savedDto);

        String json = new ObjectMapper().writeValueAsString(savedDto);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(ROOT_APP.concat("/unidades/"))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json);
        ;

        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("referencia").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("referencia").value("metro"))
        ;
    }
    @Test
    @DisplayName("Deve obter os dados de unidades de medida através do ID informado")
    public void getUnidadeTest() throws Exception {

        //Código do contrato testada
        String codigo = "229";

        UnidadeDto dto = UnidadeMedidaFactory.linearMetroDto();

        BDDMockito.given(unidadeService.getById(Mockito.any(String.class))).willReturn(dto);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(ROOT_APP.concat("/unidades/"))
                .param("id", String.valueOf(codigo))
                .accept(MediaType.APPLICATION_JSON)
                ;

        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("referencia").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("referencia").value("metro"))
        ;
    }
}
