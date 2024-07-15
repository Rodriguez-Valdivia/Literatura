package com.alura.literatura.model;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(
    int id,
    String title,
    List<String> subjects,
    List<DatosPersona> authors,
    List<DatosPersona> translators,
    List<String> bookshelves,
    List<String> languages,
    boolean copyright,
    @JsonAlias("media_type") String mediaType,
    @JsonAlias("download_count") int downloadCount
) {
}
