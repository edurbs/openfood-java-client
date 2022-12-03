package com.edurbs.openfood.client.model.input;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EnderecoInputModel {
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private CidadeInputModel cidade;
}
