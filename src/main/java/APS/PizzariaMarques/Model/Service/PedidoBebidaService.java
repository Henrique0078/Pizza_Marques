package APS.PizzariaMarques.Model.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import APS.PizzariaMarques.Model.Entity.PedidoBebidaEntity;
import APS.PizzariaMarques.Model.Repository.PedidoBebidaRepository;

@Service
public class PedidoBebidaService {
    @Autowired
    private PedidoBebidaRepository pedidoBebidaRepository;

    public List<PedidoBebidaEntity> listarPedidosBebida(int id_pedido){
        return pedidoBebidaRepository.findByIdPedido(id_pedido);
    }
    
    public List<PedidoBebidaEntity> criarPedidoBebida(List<PedidoBebidaEntity> listaBebidas){
        return pedidoBebidaRepository.saveAll(listaBebidas);
    }
}
