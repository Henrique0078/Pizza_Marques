package APS.PizzariaMarques.Model.Entity;

import org.hibernate.mapping.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_cliente;

    private String nm_cliente;

    @Column(name = "cpf_cliente")
    private String cpfCliente;

    private String logradouro_cliente;

    private String complemento_cliente;

    private String estado_cliente;

    private String cidade_cliente;

    private String numero_casa_cliente;

    private int id_usuario_cliente;

    @Transient 
    private UsuarioEntity usuario;
}
