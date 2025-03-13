package com.alexburgy.persistance;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.swapi.Planet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SWAPIDAOTest {

    @Test
    void getPlanetSuccess() throws JsonProcessingException {
        SWAPIDAO swapIDAO = new SWAPIDAO();
        Planet planet = swapIDAO.getPlanet();
        assertEquals("Tatooine", planet.getName());
    }
}