package APS.PizzariaMarques.Model.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "pizza")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PizzaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pizza;

    private String desc_pizza;

    private float preco_unitario_pizza;

    @OneToMany(mappedBy = "idPizza") // Definindo o relacionamento inverso
    private List<PedidoPizzaEntity> pedidosPizza;
}
