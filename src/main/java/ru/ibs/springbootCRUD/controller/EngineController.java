package ru.ibs.springbootCRUD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.ibs.springbootCRUD.model.Engine;
import ru.ibs.springbootCRUD.service.EngineService;

import java.util.List;

@Controller
public class EngineController {
    private final EngineService engineService;

    @Autowired
    public EngineController(EngineService engineService){this.engineService = engineService;}
    @GetMapping("/engines")
    public String findAll(Model model){
        List<Engine> engines = engineService.findAll();
        model.addAttribute("engines", engines);
        return "engine-list";
    }
    @GetMapping("/engine-create")
    public String createEngineForm(Engine engine){return "engine-create";}
    @PostMapping("/engine-create")
    public String createEngine(Engine engine){
        engineService.saveEngine(engine);
        return "redirect:/engines";

    }
    @GetMapping("engine-delete/{id}")
    public String deleteEngine(@PathVariable("id")Long id){
        if (id !=null) {
            engineService.deleteById(id);
            return "redirect:/engines";
        }
        else{
            throw new RuntimeException("Error: incorrect id");
        }

    }

    @GetMapping("/engine-update/{id}")
    public String updateEngineForm(@PathVariable("id") Long id, Model model){
        if (id !=null) {
            Engine engine = engineService.findBeId(id);
            model.addAttribute("engine", engine);
            return "redirect:/engines";
        }
        else {
            throw new RuntimeException("Error: incorrect id");
        }
    }
    @PostMapping("/engine-update")
    public String updateEngine(Engine engine){
        engineService.saveEngine(engine);
        return "redirect:/engines";
    }
}
