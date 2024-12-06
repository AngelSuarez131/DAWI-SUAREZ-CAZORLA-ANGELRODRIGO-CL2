package pe.edu._0.DAWI_SUAREZ_CAZORLA_ANGELRODRIGO.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import pe.edu._0.DAWI_SUAREZ_CAZORLA_ANGELRODRIGO.dto.FilmDetDto;
import pe.edu._0.DAWI_SUAREZ_CAZORLA_ANGELRODRIGO.dto.FilmDto;
import pe.edu._0.DAWI_SUAREZ_CAZORLA_ANGELRODRIGO.dto.FilmRegDto;

import java.util.List;

public interface MantService {

    //Listar
    @Cacheable(value = "filmcache")
    List<FilmDto> findFilms();

    //Detalle
    FilmDetDto findFilmById(int id);


    //Actualizar
    @CacheEvict(value = "filmcache",allEntries = true)
    Boolean ActualizarFilm(FilmDetDto filmDetDto);
    //@CacheEvict(value = "filmcache",allEntries = true)

    //Delete
    @CacheEvict(value = "filmcache",allEntries = true)
    FilmDetDto delFilmById(int id);
    //Insertar
    @CacheEvict(value = "filmcache",allEntries = true)
    FilmRegDto addFilm(FilmRegDto filmRegDto);



}
