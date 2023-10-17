package APS.PizzariaMarques.Model.Entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

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

    @OneToMany(mappedBy = "pizza")
    private List<PedidoPizzaEntity> pedidosPizza;
}
