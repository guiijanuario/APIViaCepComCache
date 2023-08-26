package br.com.zup.catalisa.APIViaCep.exception;

public class ViaCepFormatException extends RuntimeException {
    public ViaCepFormatException(String mensagem) {
        super(mensagem);
    }
}
