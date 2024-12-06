package pe.edu._0.DAWI_SUAREZ_CAZORLA_ANGELRODRIGO.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu._0.DAWI_SUAREZ_CAZORLA_ANGELRODRIGO.dto.FilmDetDto;
import pe.edu._0.DAWI_SUAREZ_CAZORLA_ANGELRODRIGO.dto.FilmDto;
import pe.edu._0.DAWI_SUAREZ_CAZORLA_ANGELRODRIGO.entity.Film;
import pe.edu._0.DAWI_SUAREZ_CAZORLA_ANGELRODRIGO.repository.FilmRepositoryInterface;
import pe.edu._0.DAWI_SUAREZ_CAZORLA_ANGELRODRIGO.service.MantService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MantServiceImp implements MantService {

    @Autowired
    FilmRepositoryInterface filmrepo;

    @Override
    public List<FilmDto> findFilms() {
       List<FilmDto> filmDtos = new ArrayList<>();

       Iterable<Film> iterable = filmrepo.findAll();
       iterable.forEach(f->{
           FilmDto fd = new
                   FilmDto(
                       f.getFilmId(),f.getTitle(),f.getLanguage().getName(),
                       f.getRentalDuration(),f.getRentalRate(),f.getLength(),
                       f.getRating());
           filmDtos.add(fd);
       });
        return filmDtos;
    }//Fin del findfilms para Consulta

    @Override
    public FilmDetDto findFilmById(int id) {

        Optional<Film> optional = filmrepo.findById(id);
        return  optional.map(f-> new FilmDetDto(
                    f.getFilmId(),
                    f.getTitle(),
                    f.getLanguage().getName(),
                    f.getLength(),
                    f.getRating()
                    )
            ).orElse(null);

    }//Fin del findfbyid

    @Override
    public Boolean ActualizarFilm(FilmDetDto filmDetDto) {
        Optional<Film> optional = filmrepo.findById(filmDetDto.filmId());

        return optional.map(//Tdo menos language
                f -> {
                    f.setTitle(filmDetDto.title());
                    f.setLength(filmDetDto.length());
                    f.setRating(filmDetDto.rating());
                    filmrepo.save(f);
                    return true;
                }

        ).orElse((false));
    }//Fin del actualizar

    @Override
    public FilmDetDto delFilmById(int id) {
        Optional<Film> optional = filmrepo.findById(id);

        if (optional.isPresent()) {
            filmrepo.deleteById(id);
            return new FilmDetDto(
                    optional.get().getFilmId(),
                    optional.get().getTitle(),
                    optional.get().getLanguage().getName(),
                    optional.get().getLength(),
                    optional.get().getRating()
            );
        } else {
            return null;
        }
    }//Fin del delete
    //
}
