package APS.PizzariaMarques.Model.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pedido_pizza")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoPizzaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pedido_pizza;

    @Column(name = "id_pedido_pz")
    private int idPedido;

    private int quantidade_pedido_pizza;

    private float valor_total_pedido_pizza;

    private String tamanho_pedido_pizza;

    @ManyToOne
    @JoinColumn(name = "id_pizza_ped_pz")
    private PizzaEntity pizza;  // Relacionamento com PizzaEntity

    @PrePersist
    @PreUpdate
    public void calculateTotalValue() {
        if (quantidade_pedido_pizza > 0 && pizza != null) {
            this.valor_total_pedido_pizza = quantidade_pedido_pizza * pizza.getPreco_unitario_pizza();
        } else {
            this.valor_total_pedido_pizza = 0.0f; // Ou outro valor padrão se a quantidade ou pizza for nula
        }
    }
}
