package APS.PizzariaMarques.Model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import APS.PizzariaMarques.Model.Entity.PizzaEntity;

public interface PizzaRepository extends JpaRepository<PizzaEntity, Integer>{
    
}
