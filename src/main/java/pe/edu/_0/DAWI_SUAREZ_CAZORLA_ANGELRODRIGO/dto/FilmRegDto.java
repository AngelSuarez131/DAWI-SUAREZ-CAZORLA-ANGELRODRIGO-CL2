package pe.edu._0.DAWI_SUAREZ_CAZORLA_ANGELRODRIGO.dto;

import java.util.Date;
public record FilmRegDto(Integer filmId,
                         String title,
                         Integer languageId,
                         Integer rentalDuration,
                         Double rentalRate,
                         Integer length,
                         Double replacementCost,
                         String rating,
                         Date lastUpdate) {
}
