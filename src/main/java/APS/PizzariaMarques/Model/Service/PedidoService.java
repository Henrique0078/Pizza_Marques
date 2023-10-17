package APS.PizzariaMarques.Model.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import APS.PizzariaMarques.Model.Entity.PedidoEntity;
import APS.PizzariaMarques.Model.Repository.PedidoRepository;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public Optional<PedidoEntity> listarPedido(int id_pedido){
        return pedidoRepository.findById(id_pedido);
    }

    public PedidoEntity criarPedido(PedidoEntity pedido){
        PedidoEntity newPedido = pedidoRepository.save(pedido);
        return newPedido;
    }

    public Boolean cancelarPedido(int id_pedido){
        Optional<PedidoEntity> oldPedido = pedidoRepository.findById(id_pedido);
        if(oldPedido.isPresent()) {
            PedidoEntity pedido = oldPedido.get();
            pedido.setStatus_pedido("Cancelado");
            pedidoRepository.save(pedido);
            return true;
        }else return false;
    }
}
