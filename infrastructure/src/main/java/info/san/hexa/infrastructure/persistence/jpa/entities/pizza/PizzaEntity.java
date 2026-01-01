package info.san.hexa.infrastructure.persistence.jpa.entities.pizza;

import jakarta.persistence.*;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "pizza")
@Setter
public class PizzaEntity {

    public enum Taille {
        PETITE,

        MOYENNE,

        GRANDE,

        XXL
    }

    private Integer id;

    private boolean isCalzone;

    private Taille taille;

    private List<IngredientEntity> ingredients;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    @Column(name = "is_calzone")
    public boolean isCalzone() {
        return isCalzone;
    }

    @Column
    public Taille getTaille() {
        return taille;
    }

    @ManyToMany
    @JoinTable(name = "pizza_has_ingredient")
    public List<IngredientEntity> getIngredients() {
        return ingredients;
    }
}
