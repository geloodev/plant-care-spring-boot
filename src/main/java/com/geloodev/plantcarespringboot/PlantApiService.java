package com.geloodev.plantcarespringboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PlantApiService {
    
    private final RestTemplate restTemplate;

    @Autowired
    public PlantApiService() {
        this.restTemplate = new RestTemplate();
    }

    public List<Plant> getPlantsFromApi() {
        String url = "https://trefle.io/api/v1/plants?token=9SrXibl67PyyhQ8tkCvrFaXfAV1_0YvhaVmliyC4HUg";
        ResponseEntity<PlantList> response = restTemplate.getForEntity(url, PlantList.class);
        PlantList plantList = response.getBody();
        List<Plant> plants = new ArrayList<Plant>();
        for (Data data : plantList.getData()) {
            plants.add(new Plant(data));
        }
        return plants;
    }

    public Plant getPlantFromApiById(int id) {
        String url = "https://trefle.io/api/v1/plants/" + id + "?token=9SrXibl67PyyhQ8tkCvrFaXfAV1_0YvhaVmliyC4HUg";
        ResponseEntity<Plant> response = restTemplate.getForEntity(url, Plant.class);
        return response.getBody();
    }
}
