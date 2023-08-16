package com.geloodev.plantcarespringboot;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlantList {
    
    Data[] data;

    public Data[] getData() {
        return data;
    }
}