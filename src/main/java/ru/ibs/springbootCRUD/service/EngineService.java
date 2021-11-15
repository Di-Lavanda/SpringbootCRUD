package ru.ibs.springbootCRUD.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.springbootCRUD.model.Engine;
import ru.ibs.springbootCRUD.repository.EngineRepository;

import java.util.List;

@Service
public class EngineService {

    private final EngineRepository engineRepository;

    @Autowired
    public EngineService(EngineRepository engineRepository){this.engineRepository = engineRepository;}

    public Engine findBeId(Long id){return engineRepository.getOne(id);}
    public List<Engine> findAll(){return engineRepository.findAll();}
    public Engine saveEngine(Engine engine){return engineRepository.save(engine);}
    public void deleteById(Long id){engineRepository.deleteById(id);}

}
