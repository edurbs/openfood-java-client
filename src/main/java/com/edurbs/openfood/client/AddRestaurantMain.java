package com.edurbs.openfood.client;

import java.math.BigDecimal;

import org.springframework.web.client.RestTemplate;

import com.edurbs.openfood.client.api.ClientApiException;
import com.edurbs.openfood.client.api.RestaurantClient;
import com.edurbs.openfood.client.model.input.CidadeInputModel;
import com.edurbs.openfood.client.model.input.CozinhaInputModel;
import com.edurbs.openfood.client.model.input.EnderecoInputModel;
import com.edurbs.openfood.client.model.input.RestaurantInputModel;


public class AddRestaurantMain {

    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();

        String url = "http://api.openfood.local:8080";

        var cidade = CidadeInputModel.builder()
                .id(1L)
                .build();
        
        var endereco = EnderecoInputModel.builder()
                .cep("38400-999")
                .logradouro("Rua João Pinheiro")
                .numero("123")
                .complemento(" ")
                .bairro("Centro")
                .cidade(cidade)
                .build();
        
        var cozinha = CozinhaInputModel.builder()
                .id(1L)
                .build();

        var restauranteInputModel = RestaurantInputModel.builder()
                .nome("Casa da vovo")
                .taxaFrete(new BigDecimal(10.5))
                .cozinha(cozinha)
                .endereco(endereco)
                .build();
        
        try {
            RestaurantClient restaurantClient = new RestaurantClient(url, restTemplate);
    
            var restauranteModelSalvo = restaurantClient.add(restauranteInputModel);
    
            System.out.println(restauranteModelSalvo.toString());
        } catch (ClientApiException e) {
            if(e.getProblem() != null){
                System.out.println(e.getProblem().getUserMessage());
                e.getProblem().getObjects().stream()
                        .forEach( p -> System.out.println(p.getUserMessage()));
            }else{
                e.printStackTrace();
            }
            
        }
        
      
    }
}
