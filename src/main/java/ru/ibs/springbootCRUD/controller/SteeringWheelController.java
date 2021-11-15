package ru.ibs.springbootCRUD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.ibs.springbootCRUD.model.SteeringWheel;
import ru.ibs.springbootCRUD.service.SteeringWheelService;

import java.util.List;
@Controller
public class SteeringWheelController {
    private final SteeringWheelService steeringWheelService;

    @Autowired
    public SteeringWheelController(SteeringWheelService steeringWheelService){this.steeringWheelService = steeringWheelService;}
    @GetMapping("/steering-wheels")
    public String findAll(Model model){
        List<SteeringWheel> steeringWheels = steeringWheelService.findAll();
        model.addAttribute("steeringWheels", steeringWheels);
        return "steering-wheel-list";
    }
    @GetMapping("/steering-wheel-create")
    public String createSteeringWheelForm(SteeringWheel steeringWheel){return "steering-wheel-create";}
    @PostMapping("/steering-wheel-create")
    public String createSteeringWheel(SteeringWheel steeringWheel){
        steeringWheelService.saveSteeringWheel(steeringWheel);
        return "redirect:/steering-wheels";
    }
    @GetMapping("/steering-wheel-delete/{id}")
    public String deleteSteeringWheel(@PathVariable("id")Long id){
        if (id !=null){
            steeringWheelService.deleteById(id);
            return "redirect:/steering-wheels";
        }
        else{
            throw new RuntimeException("Error: incorrect id");
        }
    }
    @GetMapping("steering-wheel-update/{id}")
    public  String updateSteeringWheelForm(@PathVariable("id")Long id, Model model){
        SteeringWheel steeringWheel = steeringWheelService.findBuId(id);
        if (id !=null){
            model.addAttribute("steering-wheel", steeringWheel);
            return "/steering-wheel-update";
        }
        else {
            throw new RuntimeException("Error: incorrect id");
        }

    }
    @PostMapping("/Steering-wheel-update")
    public  String updateSteeringWheel(SteeringWheel steeringWheel){
        steeringWheelService.saveSteeringWheel(steeringWheel);
        return "redirect:/steering-wheels";
    }
}
