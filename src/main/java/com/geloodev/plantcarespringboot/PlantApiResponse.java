package com.geloodev.plantcarespringboot;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class PlantApiResponse {
    
    List<Plant> data;

    public PlantApiResponse() {}

    /*
    public PlantApiResponse(List<Plant> data) {
        this.data = data;
    }x

    public List<Plant> getData() {
        return data;
    }
    */
}