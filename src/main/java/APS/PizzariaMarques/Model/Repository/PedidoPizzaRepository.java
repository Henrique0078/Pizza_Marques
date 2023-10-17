package APS.PizzariaMarques.Model.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import APS.PizzariaMarques.Model.Entity.PedidoPizzaEntity;

public interface PedidoPizzaRepository extends JpaRepository<PedidoPizzaEntity, Integer>{
    List<PedidoPizzaEntity> findByIdPedido(int idPedido);
}
