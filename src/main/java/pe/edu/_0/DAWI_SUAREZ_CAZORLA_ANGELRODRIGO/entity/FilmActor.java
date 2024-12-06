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

    @EmbeddedId
    private FilmActorId id;

    //private Integer actorId;
  //  private Integer filmId;
    private Date lastUpdate;

    @ManyToOne
    @MapsId("filmId")
    @JoinColumn(name = "film_id",nullable = false)
    private Film film;

    @ManyToOne
    @MapsId("actorId")
    @JoinColumn(name = "actor_id")
    private Actor actor;

}
