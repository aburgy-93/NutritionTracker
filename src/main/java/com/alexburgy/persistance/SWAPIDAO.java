package com.alexburgy.persistance;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swapi.Planet;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class SWAPIDAO {
    Planet getPlanet() throws JsonProcessingException {
        // TODO read in the uri from a properties file
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://swapi.info/api/planets/1");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        Planet planet = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
             planet = mapper.readValue(response, Planet.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return planet;
    }
}
