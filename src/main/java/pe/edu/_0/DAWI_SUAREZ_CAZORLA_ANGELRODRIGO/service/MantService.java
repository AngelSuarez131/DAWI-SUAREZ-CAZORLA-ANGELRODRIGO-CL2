package pe.edu._0.DAWI_SUAREZ_CAZORLA_ANGELRODRIGO.service;

import org.springframework.cache.annotation.Cacheable;
import pe.edu._0.DAWI_SUAREZ_CAZORLA_ANGELRODRIGO.dto.FilmDetDto;
import pe.edu._0.DAWI_SUAREZ_CAZORLA_ANGELRODRIGO.dto.FilmDto;

import java.util.List;

public interface MantService {

    //Listar
    @Cacheable(value = "filmcache")
    List<FilmDto> findFilms();

    //Detalle
    FilmDetDto findFilmById(int id);
    //@CacheEvict(value = "filmcache",allEntries = true)

    //Delete

    //Insertar

    //Actualizar
}
