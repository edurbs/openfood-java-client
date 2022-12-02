package com.edurbs.openfood.client;

import org.springframework.web.client.RestTemplate;

import com.edurbs.openfood.client.api.ClientApiException;
import com.edurbs.openfood.client.api.RestaurantClient;

public class ListRestaurantMain {
    public static void main(String[] args) {
        try {
            RestTemplate restTemplate = new RestTemplate();
    
            String url = "http://api.openfood.local:8080";
    
            RestaurantClient restaurantClient = new RestaurantClient(url, restTemplate);
    
            restaurantClient.list().stream()
                    .forEach(System.out::println);
        } catch (ClientApiException e) {
         if(e.getProblem()!= null){
            System.out.println(e.getProblem().getUserMessage());
         }else{
            e.printStackTrace();
         }            
        }
    }
}
