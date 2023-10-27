package APS.PizzariaMarques.Controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import APS.PizzariaMarques.Model.Entity.BebidaEntity;
import APS.PizzariaMarques.Model.Entity.PedidoBebidaEntity;
import APS.PizzariaMarques.Model.Entity.PedidoEntity;
import APS.PizzariaMarques.Model.Entity.PedidoPizzaEntity;
import APS.PizzariaMarques.Model.Entity.PizzaEntity;
import APS.PizzariaMarques.Model.Service.BebidaService;
import APS.PizzariaMarques.Model.Service.PedidoBebidaService;
import APS.PizzariaMarques.Model.Service.PedidoPizzaService;
import APS.PizzariaMarques.Model.Service.PedidoService;
import APS.PizzariaMarques.Model.Service.PizzaService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    
    @Autowired
    private PizzaService pizzaService;
    @Autowired
    private BebidaService bebidaService;
    @Autowired
    private PedidoService pedidoService;
    @Autowired
    private PedidoBebidaService pedidoBebidaService;
    @Autowired
    private PedidoPizzaService pedidoPizzaService;

    @GetMapping("/listarPedido/{id_pedido}")
    public ResponseEntity<?> listarPedido(@PathVariable int id_pedido){
        try {
            Optional<PedidoEntity> pedido = pedidoService.listarPedido(id_pedido);
            if(pedido.isPresent()){
                PedidoEntity completoPedido = pedido.get();
                completoPedido.setPedidoBebida(pedidoBebidaService.listarPedidosBebida(id_pedido));
                completoPedido.setPedidoPizza(pedidoPizzaService.listarPedidosPizza(id_pedido));
            }
            return ResponseEntity.ok(pedido);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao listar o pedido: " + e.getMessage());
        }
    }

    // @GetMapping("/listarPedidoPizza/{id_pedido}")
    // public ResponseEntity<?> listarPedidoPizza(@PathVariable int id_pedido){
    //     try {
    //         List<PedidoPizzaEntity> pedido = pedidoPizzaService.listarPedidosPizza(id_pedido);
    //         return ResponseEntity.ok(pedido);
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao listar o pedido: " + e.getMessage());
    //     }
    // }

    // @GetMapping("/listarPedidoBebida/{id_pedido}")
    // public ResponseEntity<?> listarPedidoBebida(@PathVariable int id_pedido){
    //     try {
    //         List<PedidoBebidaEntity> pedido = pedidoBebidaService.listarPedidosBebida(id_pedido);
    //         return ResponseEntity.ok(pedido);
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao listar o pedido: " + e.getMessage());
    //     }
    // }

    @PostMapping("/fazerPedido")
    @CrossOrigin(origins = "*") // http://127.0.0.1:5500
    public ResponseEntity<String> fazerPedido(@RequestBody PedidoEntity pedido){
        try {
            float valorTotalPedido = 0;
            List<PedidoBebidaEntity> pedidoBebida = pedido.getPedidoBebida();
            List<PedidoPizzaEntity> pedidoPizza = pedido.getPedidoPizza();
            for (PedidoBebidaEntity pedidoB : pedidoBebida) {
                BebidaEntity bebida = pedidoB.getIdBebida();
                bebida = bebidaService.findById(bebida.getId_bebida()).get();
                pedidoB.setValor_total_pedido_bebida(pedidoB.getQuantidade_pedido_bebida() * bebida.getPreco_unitario_bebida());
                valorTotalPedido = valorTotalPedido + pedidoB.getValor_total_pedido_bebida();
            }
            for (PedidoPizzaEntity pedidoP : pedidoPizza) {
                PizzaEntity pizza = pedidoP.getIdPizza();
                pizza = pizzaService.findById(pizza.getId_pizza()).get();
                pedidoP.setIdPedido(pedido.getId_pedido());
                pedidoP.setValor_total_pedido_pizza(pedidoP.getQuantidade_pedido_pizza() * pizza.getPreco_unitario_pizza());
                valorTotalPedido = valorTotalPedido + pedidoP.getValor_total_pedido_pizza();
            }
            PedidoEntity newPedido = new PedidoEntity(pedido.getId_cliente_pedido(), pedido.getStatus_pedido(), valorTotalPedido);
            pedidoService.criarPedido(newPedido);
            for (PedidoBebidaEntity pedidoB : pedidoBebida) {
                pedidoB.setIdPedido(newPedido.getId_pedido());
            }
            for (PedidoPizzaEntity pedidoP : pedidoPizza) {
                pedidoP.setIdPedido(newPedido.getId_pedido());
            }
            System.out.println(newPedido);
            pedidoBebidaService.criarPedidoBebida(pedidoBebida);
            pedidoPizzaService.criarPedidoPizza(pedidoPizza);
            
            return ResponseEntity.ok("Pedido cadastrado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao cadastrar o pedido: " + e.getMessage());
        }
    }

    @PutMapping("/cancelarPedido/{id_pedido}")
    public ResponseEntity<String> cancelarPedido(@PathVariable int id_pedido){
        try {
            boolean teste = pedidoService.cancelarPedido(id_pedido);
            if(teste){
                return ResponseEntity.ok("Pedido cancelado com sucesso!");
            }else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido não Encontrado");
            
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao cancelar o pedido: " + e.getMessage());
        }
    }

 }
