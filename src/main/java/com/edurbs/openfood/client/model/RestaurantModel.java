package com.edurbs.openfood.client.model;

import java.math.BigDecimal;

import lombok.Data;


@Data
public class RestaurantModel {
    
    private Long id;
    private String nome;
    private BigDecimal taxaFrete;
    private CozinhaModel cozinha;
    private boolean ativo;
    private boolean aberto;
    private EnderecoModel endereco;
}
