package APS.PizzariaMarques.Model.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import APS.PizzariaMarques.Model.Entity.PedidoPizzaEntity;
import APS.PizzariaMarques.Model.Repository.PedidoPizzaRepository;

@Service
public class PedidoPizzaService {
    @Autowired
    private PedidoPizzaRepository pedidoPizzaRepository;

    public List<PedidoPizzaEntity> listarPedidosPizza(int id_pedido){
        return pedidoPizzaRepository.findByIdPedido(id_pedido);
    }

    public List<PedidoPizzaEntity> criarPedidoPizza(List<PedidoPizzaEntity> listaPizzas){
        return pedidoPizzaRepository.saveAll(listaPizzas);
    }
    
}
