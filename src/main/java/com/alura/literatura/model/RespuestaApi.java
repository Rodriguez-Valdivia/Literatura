package com.alura.literatura.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RespuestaApi(
        int count,
        String next,
        String previous,
        List<DatosLibro> results
) {
}
