package ru.ibs.springbootCRUD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.ibs.springbootCRUD.model.Manual;
import ru.ibs.springbootCRUD.service.ManualService;

import java.util.List;
@RestController
public class ManualController {
    private final ManualService manualService;

    @Autowired
    public ManualController(ManualService manualService){this.manualService = manualService;}

    @GetMapping("/manuals")
    public   List<Manual> getAll(){
        return manualService.findAll();
    }
    @RequestMapping("/manual-create")
    public Manual createManual(Manual manual) {
        manualService.saveManual(manual);
        return manual;
    }

    @PostMapping("/manual-delete/{id}")
    public void deleteManual(@PathVariable Long id){
        if (id !=null){

            manualService.deleteById(id);
        }
        else{
            throw new RuntimeException("Error: incorrect id");
        }
    }
    @PostMapping("manual-update/{id}")
    public  void updateManual(@PathVariable("id")Long id,@RequestBody Manual manual){
        if (id !=null){
            manual.setId(id);
            manualService.saveManual(manual);
        }
        else {
            throw new RuntimeException("Error: incorrect id");
        }

    }
}
