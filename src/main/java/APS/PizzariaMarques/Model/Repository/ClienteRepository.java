package APS.PizzariaMarques.Model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import APS.PizzariaMarques.Model.Entity.ClienteEntity;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer>{
    ClienteEntity findByCpfCliente(String cpfCliente);
}
