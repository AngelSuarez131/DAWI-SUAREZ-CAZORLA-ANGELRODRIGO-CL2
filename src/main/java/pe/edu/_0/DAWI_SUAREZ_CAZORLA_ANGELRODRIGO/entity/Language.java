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
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer languageId;
    private String  name;
    private Date lastUpdate;

    //Poner nombre de campo a enlazar, en este caso language del private Language language;
    @OneToMany(mappedBy = "language")
    private List<Film> films;
}
