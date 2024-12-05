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
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer actorId;
    public String firstName;
    public String lastName;
    public Date lastUpdate;

    @OneToMany(mappedBy = "actor")
    private List<FilmActor> filmActors;

}
