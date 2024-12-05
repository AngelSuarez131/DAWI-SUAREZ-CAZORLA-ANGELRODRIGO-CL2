package pe.edu._0.DAWI_SUAREZ_CAZORLA_ANGELRODRIGO.dto;

public record FilmDto(Integer filmId,
                      String title,
                      String language,
                      Integer rentalDuration,
                      Double rentalRate,
                      Integer length,
                      String rating) {
}