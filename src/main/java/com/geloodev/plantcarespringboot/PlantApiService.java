package com.geloodev.plantcarespringboot;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PlantApiService {
    
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final String baseUrl;
    private final String token;

    @Autowired
    public PlantApiService() {
        this.restTemplate = new RestTemplate();
        this.objectMapper = new ObjectMapper();
        this.baseUrl = "https://trefle.io/api/v1/";
        this.token = "9SrXibl67PyyhQ8tkCvrFaXfAV1_0YvhaVmliyC4HUg";
    }

    public List<Plant> getPlantsFromApi() {
        String url = baseUrl + "plants?token=" + token;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        try {
            JsonNode rootNode = objectMapper.readTree(response.getBody());
            JsonNode dataNode = rootNode.get("data");
            List<Plant> plants = objectMapper.readValue(dataNode.toString(), new TypeReference<List<Plant>>() {});
            return plants;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Plant getPlantFromApiById(int id) {
        String url = baseUrl + "plants/" + id + "?token=" + token;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);        
        try {
            JsonNode rootNode = objectMapper.readTree(response.getBody());
            JsonNode dataNode = rootNode.get("data");
            Plant plant = objectMapper.readValue(dataNode.toString(), new TypeReference<Plant>() {});
            return plant;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
