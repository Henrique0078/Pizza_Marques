package APS.PizzariaMarques.Model.Entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "bebida")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BebidaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_bebida;

    private String desc_bebida;

    private float preco_unitario_bebida;
}
