package pe.edu._0.DAWI_SUAREZ_CAZORLA_ANGELRODRIGO.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.nio.MappedByteBuffer;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer filmId;
    private String title;
    private String description;
    private Integer releaseYear;
 //   private Integer languageId; Ya viene con la clase inferior
    private Integer originalLanguageId;
    private Integer rentalDuration;
    private Double rentalRate;
    private Integer length;
    private Double replacementCost;
    private String rating;
    private String specialFeatures;
    private Date lastUpdate;


    //Poner en el join column el nombre exacto de la llave foranea en la tabla
    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;

    @OneToOne(mappedBy = "film",cascade = CascadeType.REMOVE,orphanRemoval = true)
    private FilmCategory filmCategory;

    @OneToMany(mappedBy = "film",cascade = CascadeType.REMOVE,orphanRemoval = true)
    private List<Inventory> inventories;

    @OneToMany(mappedBy = "film",cascade = CascadeType.REMOVE,orphanRemoval = true)
    private List<FilmActor> filmActors;


}
