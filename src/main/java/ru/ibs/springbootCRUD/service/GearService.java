package ru.ibs.springbootCRUD.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.springbootCRUD.model.Gear;
import ru.ibs.springbootCRUD.repository.GearRepository;

import java.util.List;

@Service
public class GearService {

    private final GearRepository gearRepository;

    @Autowired
    public GearService(GearRepository gearRepository){this.gearRepository = gearRepository;}

    public Gear findById(Long id){return gearRepository.findById(id).orElse(null);}
    public List<Gear> findAll(){return gearRepository.findAll();}
    public Gear saveGear(Gear gear){return gearRepository.save(gear);}
    public void deleteById(Long id){gearRepository.deleteById(id);}
}
