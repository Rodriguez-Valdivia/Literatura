package com.alura.literatura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosPersona(
        @JsonAlias("birth_year") int birthYear,
        @JsonAlias("death_year") int deathYear,
        @JsonAlias("name") String name
) {
}