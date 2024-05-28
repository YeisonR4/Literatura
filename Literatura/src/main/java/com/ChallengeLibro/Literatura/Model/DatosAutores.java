package com.ChallengeLibro.Literatura.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public record DatosAutores(

        @JsonAlias("name") String nombre,
        @JsonAlias("death_year") String fechaMuerte
) {
}
