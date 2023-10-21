package APS.PizzariaMarques.Model.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import APS.PizzariaMarques.Model.Entity.BebidaEntity;
import APS.PizzariaMarques.Model.Repository.BebidaRepository;

@Service
public class BebidaService {
    @Autowired
    private BebidaRepository bebidaRepository;

    public List<BebidaEntity> listarBebidas(){
        return bebidaRepository.findAll();
    }

    public Optional<BebidaEntity> findById(int id){
        return bebidaRepository.findById(id);
    }
}
