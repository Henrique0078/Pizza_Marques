package APS.PizzariaMarques.Model.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pedido_bebida")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoBebidaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pedido_bebida;

    @Column(name = "id_pedido_bb")
    private int idPedido;

    private int quantidade_pedido_bebida;

    private float valor_total_pedido_bebida;

    @ManyToOne
    @JoinColumn(name = "id_bebida_ped_bb")
    private BebidaEntity idBebida;
}
