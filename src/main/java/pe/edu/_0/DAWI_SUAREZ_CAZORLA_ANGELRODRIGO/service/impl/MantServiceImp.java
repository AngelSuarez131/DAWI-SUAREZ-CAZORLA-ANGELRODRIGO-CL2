package pe.edu._0.DAWI_SUAREZ_CAZORLA_ANGELRODRIGO.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu._0.DAWI_SUAREZ_CAZORLA_ANGELRODRIGO.dto.FilmDetDto;
import pe.edu._0.DAWI_SUAREZ_CAZORLA_ANGELRODRIGO.dto.FilmDto;
import pe.edu._0.DAWI_SUAREZ_CAZORLA_ANGELRODRIGO.dto.FilmRegDto;
import pe.edu._0.DAWI_SUAREZ_CAZORLA_ANGELRODRIGO.entity.Film;
import pe.edu._0.DAWI_SUAREZ_CAZORLA_ANGELRODRIGO.entity.Language;
import pe.edu._0.DAWI_SUAREZ_CAZORLA_ANGELRODRIGO.repository.FilmRepositoryInterface;
import pe.edu._0.DAWI_SUAREZ_CAZORLA_ANGELRODRIGO.repository.LangRepositoryInterface;
import pe.edu._0.DAWI_SUAREZ_CAZORLA_ANGELRODRIGO.service.MantService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MantServiceImp implements MantService {

    @Autowired
    FilmRepositoryInterface filmrepo;

    @Autowired
    LangRepositoryInterface LangRepos;

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

    @Override
    public FilmRegDto addFilm(FilmRegDto filmRegDto) {
        Film film = new Film();

        film.setTitle(filmRegDto.title());
        film.setRentalDuration(filmRegDto.rentalDuration());
        film.setRentalRate(filmRegDto.rentalRate());
        film.setLength(filmRegDto.length());
        film.setReplacementCost(filmRegDto.replacementCost());
        film.setRating(filmRegDto.rating());
        film.setLastUpdate(filmRegDto.lastUpdate());

        Optional<Language> optional = LangRepos.findById(filmRegDto.languageId());
        if (optional.isPresent()) {
            film.setLanguage(optional.get());
        } else {
            throw new IllegalArgumentException("Id no valido ");
        }

        Film savedFilm = filmrepo.save(film);

        return new FilmRegDto(
                savedFilm.getFilmId(),
                savedFilm.getTitle(),
                savedFilm.getLanguage().getLanguageId(),
                savedFilm.getRentalDuration(),
                savedFilm.getRentalRate(),
                savedFilm.getLength(),
                savedFilm.getReplacementCost(),
                savedFilm.getRating(),
                savedFilm.getLastUpdate()
        );
    }
    //
}
