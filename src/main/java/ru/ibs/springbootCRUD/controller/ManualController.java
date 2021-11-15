package ru.ibs.springbootCRUD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.ibs.springbootCRUD.model.Manual;
import ru.ibs.springbootCRUD.service.ManualService;

import java.util.List;
@Controller
public class ManualController {
    private final ManualService manualService;

    @Autowired
    public ManualController(ManualService manualService){this.manualService = manualService;}
    @GetMapping("/manuals")
    public String findAll(Model model){
        List<Manual> manuals = manualService.findAll();
        model.addAttribute("manuals", manuals);
        return "manual-list";
    }
    @GetMapping("/manual-create")
    public String createManualForm(Manual manual){return "manual-create";}
    @PostMapping("/manual-create")
    public String createManual(Manual manual){
        manualService.saveManual(manual);
        return "redirect:/manuals";
    }
    @GetMapping("/manual-delete/{id}")
    public String deleteManual(@PathVariable("id")Long id){
        if (id !=null){
            manualService.deleteById(id);
            return "redirect:/manuals";
        }
        else{
            throw new RuntimeException("Error: incorrect id");
        }
    }
    @GetMapping("manual-update/{id}")
    public  String updateManualForm(@PathVariable("id")Long id, Model model){
        Manual manual = manualService.findBuId(id);
        if (id !=null){
            model.addAttribute("manual", manual);
            return "/manual-update";
        }
        else {
            throw new RuntimeException("Error: incorrect id");
        }

    }
    @PostMapping("/Manual-update")
    public  String updateManual(Manual manual){
        manualService.saveManual(manual);
        return "redirect:/manuals";
    }
}
