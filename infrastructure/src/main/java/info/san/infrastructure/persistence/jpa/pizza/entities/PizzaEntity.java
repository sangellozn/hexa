package info.san.infrastructure.persistence.jpa.pizza.entities;

import jakarta.persistence.*;
import lombok.Setter;

import java.util.List;
import java.util.Set;

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

    private Long id;

    private boolean isCalzone;

    private Taille taille;

    private List<IngredientEntity> ingredients;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    @Column
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
