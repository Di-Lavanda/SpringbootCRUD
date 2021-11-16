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

    public Manual findById(Long id){return manualRepository.findById(id).orElse(null);}
    public List<Manual> findAll(){return manualRepository.findAll();}
    public void saveManual(Manual manual){manualRepository.save(manual);}
    public void deleteById(Long id){manualRepository.deleteById(id);}

}
