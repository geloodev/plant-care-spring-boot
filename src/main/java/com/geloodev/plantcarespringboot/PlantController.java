package com.geloodev.plantcarespringboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plants")
public class PlantController {
    
    private final PlantApiService plantApiService;

    @Autowired
    public PlantController() {
        plantApiService = new PlantApiService();
    }

    @GetMapping
    public List<Plant> getPlants() {
        return plantApiService.getPlantsFromApi();
    }

    @GetMapping("/{id}")
    public Plant getPlantById(@PathVariable("id") int id) {
        return plantApiService.getPlantFromApiById(id);
    }
}
