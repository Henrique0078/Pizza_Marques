package APS.PizzariaMarques.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import APS.PizzariaMarques.Model.Entity.ClienteEntity;
import APS.PizzariaMarques.Model.Entity.UsuarioEntity;
import APS.PizzariaMarques.Model.Service.ClienteService;
import APS.PizzariaMarques.Model.Service.UsuarioService;

@RestController
@CrossOrigin("*")
@RequestMapping("/authentication")
public class LoginController {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ClienteService clienteService;

    @PostMapping("/registerCliente")
    public ResponseEntity<?> cadastrarCliente(@RequestBody ClienteEntity newCliente){
        try {
            UsuarioEntity usuario = newCliente.getUsuario();
            usuarioService.cadastrarUsuario(usuario);
            usuario.setId_usuario(usuario.getId_usuario());
            newCliente.setId_usuario_cliente(usuario.getId_usuario());
            clienteService.criarCliente(newCliente);
            return ResponseEntity.ok(usuario);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao cadastrar Cliente: " + e.getMessage());
        }
    }


    @GetMapping("/signIn")
    public ResponseEntity<?> logarUsuario(@RequestBody UsuarioEntity usuario){
        try {
            ResponseEntity<UsuarioEntity> sUsuario = usuarioService.logarUsuario(usuario.getEmailUsuario(), usuario.getSenha_usuario());
            return ResponseEntity.status(HttpStatus.OK).body(sUsuario);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao Autenticar: " + e.getMessage());
        }
    }

    @PutMapping("/alterarCliente")
    public ResponseEntity<?> alterarCliente(@RequestBody ClienteEntity cliente){
        try {
            return clienteService.alterarCliente(cliente);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao alterar cliente: " + e.getMessage());
        }
    }
}
