package APS.PizzariaMarques.Model.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import APS.PizzariaMarques.Model.Entity.PizzaEntity;
import APS.PizzariaMarques.Model.Repository.PizzaRepository;

@Service
public class PizzaService {
    @Autowired
    private PizzaRepository pizzaRepository;

    public List<PizzaEntity> listarPizzas(){
        return pizzaRepository.findAll();
    }
    public Optional<PizzaEntity> findById(int id){
        return pizzaRepository.findById(id);
    }

}
