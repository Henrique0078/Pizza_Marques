package APS.PizzariaMarques.Model.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import APS.PizzariaMarques.Model.Entity.ClienteEntity;
import APS.PizzariaMarques.Model.Repository.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public ResponseEntity<ClienteEntity> criarCliente(ClienteEntity cliente){
        ClienteEntity newCliente = clienteRepository.findByCpfCliente(cliente.getCpfCliente());
        if(newCliente != null){
            return new ResponseEntity<ClienteEntity>(newCliente, HttpStatus.UNAUTHORIZED);
        }else{
            clienteRepository.save(cliente);
        return new ResponseEntity<ClienteEntity>(newCliente, HttpStatus.CREATED);
        }
    }
}
