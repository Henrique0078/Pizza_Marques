package APS.PizzariaMarques.Model.Entity;


import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pedido")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pedido;

    private int id_cliente_pedido;

    private String status_pedido;

    private String forma_pagamento_pedido;

    @Column(name = "preco_total_pedido")
    private float valorTotalPedido;

    public PedidoEntity(int id_cliente_pedido, String status_pedido, float valorTotalPedido){
        this.id_cliente_pedido = id_cliente_pedido;
        this.status_pedido = status_pedido;
        this.valorTotalPedido = valorTotalPedido;
    }

    @Transient
    private List<PedidoBebidaEntity> pedidoBebida;

    @Transient 
    private List<PedidoPizzaEntity> pedidoPizza;

}

