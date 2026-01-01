package info.san.infrastructure.persistence.jpa.pizza.entities;

import jakarta.persistence.*;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "ingredient")
@Setter
public class IngredientEntity {

    private Long id;

    private String nom;

    private BigDecimal prixUnitaire;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    @Column(name = "nom", length = 50, nullable = false)
    public String getNom() {
        return nom;
    }

    @Column(name = "prix", scale = 12, precision = 2, nullable = false)
    public BigDecimal getPrixUnitaire() {
        return prixUnitaire;
    }

}
