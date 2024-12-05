package pe.edu._0.DAWI_SUAREZ_CAZORLA_ANGELRODRIGO.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmActor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //private Integer actorId;
  //  private Integer filmId;
    private Date lastUpdate;

    @ManyToOne
    @JoinColumn(name = "film_id",nullable = false)
    private Film film;

    @ManyToOne
    @JoinColumn(name = "actor_id")
    private Actor actor;

}
