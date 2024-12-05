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
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer inventoryId;
    //public Integer filmId;
    public Integer storeId;
    public Date lastUpdate;

    @ManyToOne
    @JoinColumn(name = "film_id")
    public Film film;
}
