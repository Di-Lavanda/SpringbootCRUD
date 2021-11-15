package ru.ibs.springbootCRUD.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.springbootCRUD.model.Manual;
import ru.ibs.springbootCRUD.repository.ManualRepository;

import java.util.List;
@Service
public class ManualService {
    private final ManualRepository manualRepository;

    @Autowired
    public ManualService(ManualRepository manualRepository){this.manualRepository = manualRepository;}

    public Manual findBuId(Long id){return manualRepository.getOne(id);}
    public List<Manual> findAll(){return manualRepository.findAll();}
    public Manual saveManual(Manual manual){return manualRepository.save(manual);}
    public void deleteById(Long id){manualRepository.deleteById(id);}

}
