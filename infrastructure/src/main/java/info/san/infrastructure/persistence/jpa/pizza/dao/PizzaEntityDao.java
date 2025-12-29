package info.san.infrastructure.persistence.jpa.pizza.dao;

import info.san.infrastructure.persistence.jpa.pizza.entities.PizzaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaEntityDao extends JpaRepository<PizzaEntity, Long> {

    // no-op

}
