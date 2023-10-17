package APS.PizzariaMarques.Model.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import APS.PizzariaMarques.Model.Entity.PedidoBebidaEntity;

public interface PedidoBebidaRepository extends JpaRepository<PedidoBebidaEntity, Integer>{
    List<PedidoBebidaEntity> findByIdPedido(int idPedido);
}
