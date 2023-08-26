package br.com.zup.catalisa.APIViaCep.controller;

import br.com.zup.catalisa.APIViaCep.service.ViaCepService;
import br.com.zup.catalisa.APIViaCep.model.CepModel;
import br.com.zup.catalisa.APIViaCep.validations.CepValidations;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/buscaCep", produces = {"application/json"})
public class ViaCepController {

    @Autowired
    ViaCepService viaCepService;

    @Autowired
    CepValidations cepValidations;

    @GetMapping(path = "/{cep}")
    @Operation(summary = " : Busca endereço pelo CEP", method = "GET")
    @Cacheable("cep")
    public CepModel buscaCep(@PathVariable String cep){

        if(cep.length() >= 9){
          String cepSemMascara = cepValidations.removedorDeMascaraCep(cep);
          return viaCepService.findCep(cepSemMascara);
        }
       return viaCepService.findCep(cep);
    }
}
