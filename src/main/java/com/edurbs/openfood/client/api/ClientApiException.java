package com.edurbs.openfood.client.api;

import org.springframework.web.client.RestClientResponseException;

import com.edurbs.openfood.client.model.Problem;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClientApiException extends RuntimeException {

    @Getter
    private Problem problem;

    public ClientApiException(String message, RestClientResponseException cause) {
        super(message, cause);

        deserializeProblem(cause);
    }

    private void deserializeProblem(RestClientResponseException cause){
        ObjectMapper mapper = new ObjectMapper();

        mapper.registerModule(new JavaTimeModule());
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {
            this.problem=mapper.readValue(cause.getResponseBodyAsString(), Problem.class);
        } catch (Exception e) {
            log.warn("Cannot deserialize the response in a problem", e);
        }
        
    }

}
