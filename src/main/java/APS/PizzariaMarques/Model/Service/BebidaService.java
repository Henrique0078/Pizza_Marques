package APS.PizzariaMarques.Model.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import APS.PizzariaMarques.Model.Entity.BebidaEntity;
import APS.PizzariaMarques.Model.Repository.BebidaRepository;

public class BebidaService {
    @Autowired
    private BebidaRepository bebidaRepository;

    public List<BebidaEntity> listarBebidas(){
        return bebidaRepository.findAll();
    }
}
