package APS.PizzariaMarques.Model.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import APS.PizzariaMarques.Model.Entity.UsuarioEntity;
import APS.PizzariaMarques.Model.Repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public ResponseEntity<UsuarioEntity> cadastrarUsuario(UsuarioEntity newUsuario){
        UsuarioEntity usuario = usuarioRepository.findByEmailUsuario(newUsuario.getEmailUsuario());
        if(usuario != null){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        else{
            usuarioRepository.save(newUsuario);
            return new ResponseEntity<UsuarioEntity>(newUsuario,HttpStatus.CREATED);
        }
    }

    public ResponseEntity<UsuarioEntity> logarUsuario(String email_usuario, String senha_usuario) {
        UsuarioEntity usuario = usuarioRepository.findByEmailUsuario(email_usuario);
        
        if (usuario != null) {
            if (usuario.getSenha_usuario().equals(senha_usuario)) {
                return new ResponseEntity<>(usuario, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}
