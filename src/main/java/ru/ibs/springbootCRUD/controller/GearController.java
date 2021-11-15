package ru.ibs.springbootCRUD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.ibs.springbootCRUD.model.Car;
import ru.ibs.springbootCRUD.model.Gear;
import ru.ibs.springbootCRUD.service.GearService;

import java.util.List;

@Controller
public class GearController {
    private final GearService gearService;

    @Autowired
    public GearController(GearService gearService){this.gearService = gearService;}
    @GetMapping("/gears")
    public String findAll(Model model) {
        List<Gear> gears = gearService.findAll();
        model.addAttribute("gears", gears);
        return "gear-list";
    }
    @GetMapping("/gear-create")
    public String createGearForm(Gear gear){return "gear-create";}
    @PostMapping("/gear-create")
    public String createGear(Gear gear){
        gearService.saveGear(gear);
        return "redirect:/gears";
    }
    @GetMapping("gear-delete/{id}")
    public String deleteGear(@PathVariable("id")Long id){
        if (id !=null){
            gearService.deleteById(id);
            return "redirect:/gears";
        }
        else{
            throw new RuntimeException("Error: incorrect id");
        }
    }
    @GetMapping("gear-update/{id}")
    public String updateGearForm(@PathVariable("id") Long id, Model model){
        Gear gear = gearService.findById(id);
        if (id !=null){
            model.addAttribute("gear", gear);
            return "/gear-update";}
        else {
            throw new RuntimeException("Error: incorrect id");
        }

    }
    @PostMapping("/gear-update")
    public String updateGear(Gear gear){
        gearService.saveGear(gear);
        return "redirect:/gears";
    }
}
