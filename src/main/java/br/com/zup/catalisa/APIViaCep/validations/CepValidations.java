package br.com.zup.catalisa.APIViaCep.validations;

import br.com.zup.catalisa.APIViaCep.exception.ViaCepFormatException;
import br.com.zup.catalisa.APIViaCep.exception.ViaCepNullException;
import org.springframework.stereotype.Service;

import java.util.Objects;
@Service
public class CepValidations {
    public static void validaCep(String cep) throws ViaCepNullException {
        if (Objects.isNull(cep) || cep.isEmpty() || cep.isBlank()) throw new ViaCepNullException("O cep informado não pode ser nulo ou vazio");
        if (cep.length() < 8) throw new ViaCepNullException("CEP faltando numeros");
    }
    public String removedorDeMascaraCep(String cep){
        try {
            validaCep(cep);
            return cep;
        } catch (ViaCepFormatException e){
            return cep.replace("-", "");
        }
    }
}
