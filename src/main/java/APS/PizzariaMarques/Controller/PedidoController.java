package APS.PizzariaMarques.Controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import APS.PizzariaMarques.Model.Entity.PedidoBebidaEntity;
import APS.PizzariaMarques.Model.Entity.PedidoEntity;
import APS.PizzariaMarques.Model.Entity.PedidoPizzaEntity;
import APS.PizzariaMarques.Model.Service.PedidoBebidaService;
import APS.PizzariaMarques.Model.Service.PedidoPizzaService;
import APS.PizzariaMarques.Model.Service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
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
            return ResponseEntity.ok(pedido);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao listar o pedido: " + e.getMessage());
        }
    }

    @GetMapping("/listarPedidoPizza/{id_pedido}")
    public ResponseEntity<?> listarPedidoPizza(@PathVariable int id_pedido){
        try {
            List<PedidoPizzaEntity> pedido = pedidoPizzaService.listarPedidosPizza(id_pedido);
            return ResponseEntity.ok(pedido);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao listar o pedido: " + e.getMessage());
        }
    }

    @GetMapping("/listarPedidoBebida/{id_pedido}")
    public ResponseEntity<?> listarPedidoBebida(@PathVariable int id_pedido){
        try {
            List<PedidoBebidaEntity> pedido = pedidoBebidaService.listarPedidosBebida(id_pedido);
            return ResponseEntity.ok(pedido);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao listar o pedido: " + e.getMessage());
        }
    }

    @PostMapping("/fazerPedido")
    public ResponseEntity<String> fazerPedido(@RequestBody PedidoEntity pedido){
        try {
            pedidoService.criarPedido(pedido);
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

    @PostMapping("/fazerPedidoPizza")
    public ResponseEntity<String> fazerPedidoPizza(@RequestBody List<PedidoPizzaEntity> pedidoPizza){
        try {
            pedidoPizzaService.criarPedidoPizza(pedidoPizza);
            return ResponseEntity.ok("Pedido pizza cadastrado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao cadastrar o pedido pizza: " + e.getMessage());
        }
    }

    @PostMapping("/fazerPedidoBebida")
    public ResponseEntity<String> fazerPedidoBebida(@RequestBody List<PedidoBebidaEntity> pedidoBebida){
        try {
            pedidoBebidaService.criarPedidoBebida(pedidoBebida);
            return ResponseEntity.ok("Pedido bebida cadastrado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao cadastrar o pedido bebida: " + e.getMessage());
        }
    }
}
