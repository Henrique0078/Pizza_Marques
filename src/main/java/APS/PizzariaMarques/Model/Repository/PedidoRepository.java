package APS.PizzariaMarques.Model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import APS.PizzariaMarques.Model.Entity.PedidoEntity;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Integer>{
    
}
