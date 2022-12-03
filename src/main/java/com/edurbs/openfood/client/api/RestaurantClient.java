package com.edurbs.openfood.client.api;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.edurbs.openfood.client.model.RestaurantBriefModel;
import com.edurbs.openfood.client.model.RestaurantModel;
import com.edurbs.openfood.client.model.input.RestaurantInputModel;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class RestaurantClient {
    private String url;
    private static final String RESOURCE_PATH = "/restaurantes";

    private RestTemplate restTemplate;

    public List<RestaurantBriefModel> list(){
        try {
            var uri = getUri();
            RestaurantBriefModel[] restaurantsBriefModel = restTemplate.getForObject(uri, RestaurantBriefModel[].class);
    
            return Arrays.asList(restaurantsBriefModel);
        } catch (RestClientResponseException e) {
         
            throw new ClientApiException(e.getMessage(), e);
        }
    }

    public RestaurantModel add(RestaurantInputModel restauranteInputModel){
        try {
            
         

            return restTemplate.postForObject(getUri(), restauranteInputModel, RestaurantModel.class);
    

        } catch (RestClientResponseException e) {
            throw new ClientApiException(e.getMessage(), e);
        }
        
    }

    private URI getUri(){
        return URI.create(url+RESOURCE_PATH);
    }
}
