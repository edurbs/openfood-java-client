package com.edurbs.openfood.client.model.input;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RestaurantInputModel {
    private String nome;
    private BigDecimal taxaFrete;
    private CozinhaInputModel cozinha;
    private EnderecoInputModel endereco;
}
