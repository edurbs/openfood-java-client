package com.edurbs.openfood.client.api;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.edurbs.openfood.client.model.RestaurantBriefModel;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RestaurantClient {
    private String url;
    private static final String RESOURCE_PATH = "/restaurantesss";

    private RestTemplate restTemplate;

    public List<RestaurantBriefModel> list(){
        try {
            URI resourceUri = URI.create(url+RESOURCE_PATH);
            RestaurantBriefModel[] restaurantsBriefModel = restTemplate.getForObject(resourceUri, RestaurantBriefModel[].class);
    
            return Arrays.asList(restaurantsBriefModel);
        } catch (RestClientResponseException e) {
         
            throw new ClientApiException(e.getMessage(), e);
        }
    }
}
