package pe.edu._0.DAWI_SUAREZ_CAZORLA_ANGELRODRIGO.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmCategory {

    @EmbeddedId
    private FilmCategoryId id;
    //private Integer filmId;
    //private Integer categoryId;
    private Date lastUpdate;

    @ManyToOne
    @MapsId("categoryId")
    @JoinColumn(name = "category_id",nullable = false)
    private Category category;

    @OneToOne
    @MapsId("filmId")
    @JoinColumn(name = "film_id",nullable = false)
    public Film film;


}
