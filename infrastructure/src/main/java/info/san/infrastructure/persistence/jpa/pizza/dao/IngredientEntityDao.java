package info.san.infrastructure.persistence.jpa.pizza.dao;

import info.san.infrastructure.persistence.jpa.pizza.entities.IngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientEntityDao extends JpaRepository<IngredientEntity, Long> {

    // no-op

}
