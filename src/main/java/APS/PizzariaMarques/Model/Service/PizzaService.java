package APS.PizzariaMarques.Model.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import APS.PizzariaMarques.Model.Entity.PizzaEntity;
import APS.PizzariaMarques.Model.Repository.PizzaRepository;

public class PizzaService {
    @Autowired
    private PizzaRepository pizzaRepository;

    public List<PizzaEntity> listarPizzas(){
        return pizzaRepository.findAll();
    }

}
