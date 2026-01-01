package info.san.hexa.domain.pizza.service;

import info.san.hexa.domain.core.exceptions.NumeroPageOuTailleInvalideException;
import info.san.hexa.domain.core.model.common.Page;
import info.san.hexa.domain.core.model.pizza.Pizza;
import info.san.hexa.domain.core.ports.in.IRecuperationPizza;
import info.san.hexa.domain.core.ports.out.pizza.IPizzaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecuperationPizzaService implements IRecuperationPizza {

    private final IPizzaRepository pizzaRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<Pizza> findById(Long id) {
        return pizzaRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Pizza> findPage(int numeroPage, int taille) {
        if (numeroPage < 0 || taille < 0) {
            throw new NumeroPageOuTailleInvalideException("La taille de la page ou le numéro de page doit être > 0");
        }
        return new Page<> (pizzaRepository.getPage(numeroPage, taille), numeroPage, taille);
    }
}
