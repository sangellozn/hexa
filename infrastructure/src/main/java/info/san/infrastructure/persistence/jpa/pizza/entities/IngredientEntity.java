package info.san.infrastructure.persistence.jpa.pizza.entities;

import jakarta.persistence.*;
import lombok.Setter;

@Entity
@Table(name = "ingredients")
@Setter
public class IngredientEntity {

    private Long id;

    @Id
    @GeneratedValue(generator = "s_ingredients", strategy = GenerationType.SEQUENCE)
    public Long getId() {
        return id;
    }

    // TODO finir

}
