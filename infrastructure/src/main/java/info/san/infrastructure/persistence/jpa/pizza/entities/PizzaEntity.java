package info.san.infrastructure.persistence.jpa.pizza.entities;

import jakarta.persistence.*;
import lombok.Setter;

@Entity
@Table(name = "pizzas")
@Setter
public class PizzaEntity {

    private Long id;

    @Id
    @GeneratedValue(generator = "s_pizza", strategy = GenerationType.SEQUENCE)
    public Long getId() {
        return id;
    }

    // TODO finir

}
