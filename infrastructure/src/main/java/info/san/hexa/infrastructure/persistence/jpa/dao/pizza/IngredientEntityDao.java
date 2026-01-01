package info.san.hexa.infrastructure.persistence.jpa.dao.pizza;

import info.san.hexa.infrastructure.persistence.jpa.entities.pizza.IngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientEntityDao extends JpaRepository<IngredientEntity, Long> {

    // no-op

}
