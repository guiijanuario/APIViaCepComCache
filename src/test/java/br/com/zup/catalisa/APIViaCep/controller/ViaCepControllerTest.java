package br.com.zup.catalisa.APIViaCep.controller;

import br.com.zup.catalisa.APIViaCep.model.CepModel;
import br.com.zup.catalisa.APIViaCep.service.ViaCepService;
import br.com.zup.catalisa.APIViaCep.validations.CepValidations;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = ViaCepController.class)
public class ViaCepControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ViaCepService viaCepService;

    @MockBean
    private CepValidations cepValidations;

    @Test
    public void testBuscaCep() throws Exception {
        String testCep = "87040360";

        CepModel testCepModel = new CepModel();
        testCepModel.setCep(testCep);

        when(viaCepService.findCep(testCep)).thenReturn(testCepModel);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/buscaCep/{cep}", testCep))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.cep").value(testCep));
    }
}
