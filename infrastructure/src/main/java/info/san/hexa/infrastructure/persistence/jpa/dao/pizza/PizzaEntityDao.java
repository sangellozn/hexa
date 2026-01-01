package info.san.hexa.infrastructure.persistence.jpa.dao.pizza;

import info.san.hexa.infrastructure.persistence.jpa.entities.pizza.PizzaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaEntityDao extends JpaRepository<PizzaEntity, Long> {

    // no-op

}
