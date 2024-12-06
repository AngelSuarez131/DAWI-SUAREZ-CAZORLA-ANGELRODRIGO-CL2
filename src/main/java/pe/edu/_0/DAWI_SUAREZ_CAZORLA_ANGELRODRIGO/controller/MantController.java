package pe.edu._0.DAWI_SUAREZ_CAZORLA_ANGELRODRIGO.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu._0.DAWI_SUAREZ_CAZORLA_ANGELRODRIGO.dto.FilmDetDto;
import pe.edu._0.DAWI_SUAREZ_CAZORLA_ANGELRODRIGO.dto.FilmDto;
import pe.edu._0.DAWI_SUAREZ_CAZORLA_ANGELRODRIGO.service.MantService;

import java.util.List;

@Controller
@RequestMapping("/mantenimiento")
public class MantController {
    @Autowired
    MantService mantService;

    @GetMapping("/consulta")
    public String consulta(Model model){
        List<FilmDto> films = mantService.findFilms();
        model.addAttribute("films",films);
        return "manten";
    }//Fin pag consulta

    @GetMapping("/detail/{id}")
    public String detalle(@PathVariable Integer id, Model model){
        FilmDetDto filmDetDto = mantService.findFilmById(id);
        model.addAttribute("film",filmDetDto);
        return "manten_detalle";
    }//Fin pag detalle

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        FilmDetDto filmDetDto = mantService.findFilmById(id);
        model.addAttribute("film",filmDetDto);
        return "manten_edit";
    }//Fin pag edit
    @PostMapping("/conf-edit")
    public String editConfirm(@ModelAttribute FilmDetDto filmDetDto, Model model){
        mantService.ActualizarFilm(filmDetDto);
        return "redirect:/mantenimiento/consulta";
    }//Fin confirmacion del edit

    @GetMapping("/elim/{id}")
    public String elim(@PathVariable Integer id, Model model){
        FilmDetDto filmDetDto = mantService.findFilmById(id);
        model.addAttribute("film",filmDetDto);
        return "manten_eli";
    }//Fin confirmacion del edit

    @PostMapping("/conf-elim")
    public String elimConfirm(@ModelAttribute FilmDetDto filmDetDto, Model model){
        mantService.delFilmById(filmDetDto.filmId());
        return "redirect:/mantenimiento/consulta";
    }//Fin confirmacion del edit

}
