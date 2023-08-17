package com.geloodev.plantcarespringboot;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Plant { 
    
    private int id;

    @JsonProperty("common_name")
    private String commonName;

    @JsonProperty("scientific_name")
    private String scientificName;

    public Plant() {}
}