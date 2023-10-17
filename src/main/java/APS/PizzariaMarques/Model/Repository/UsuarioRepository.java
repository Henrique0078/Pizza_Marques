package APS.PizzariaMarques.Model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import APS.PizzariaMarques.Model.Entity.UsuarioEntity;



public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer>{
    UsuarioEntity findByEmailUsuario(String email_usuario);
}
