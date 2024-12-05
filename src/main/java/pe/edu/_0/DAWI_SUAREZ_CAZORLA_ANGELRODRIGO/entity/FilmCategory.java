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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //private Integer filmId;
    //private Integer categoryId;
    private Date lastUpdate;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToOne
    @JoinColumn(name = "film_id")
    public Film film;


}
