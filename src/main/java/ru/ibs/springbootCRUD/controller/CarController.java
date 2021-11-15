package ru.ibs.springbootCRUD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.ibs.springbootCRUD.model.Car;
import ru.ibs.springbootCRUD.service.CarService;

import java.util.List;

@Controller
public class CarController {
    private final CarService carService;


    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }
    @GetMapping("/cars")
    public String findAll(Model model){
        List<Car> cars = carService.findAll();
        model.addAttribute("cars", cars);
        return "car-list";
    }
    @GetMapping("/car-create")
    public String createCarForm(Car car){
        return "car-create";
    }
    @PostMapping("/car-create")
    public String createCar(Car car){
        carService.saveCar(car);
        return "redirect:/cars";
    }
    @GetMapping("car-delete/{id}")
    public String deleteCar(@PathVariable("id") Long id){
        if (id !=null){
        carService.deleteById(id);
        return "redirect:/cars";}
        else {
            throw new RuntimeException("Error: incorrect id");
        }

    }
    @GetMapping("car-update/{id}")
    public String updateCarrForm(@PathVariable("id") Long id, Model model){
        if (id !=null){
        Car car = carService.findById(id);
        model.addAttribute("car", car);
        return "/car-update";}
        else {
            throw new RuntimeException("Error: incorrect id");
        }

    }
    @PostMapping("/car-update")
    public String updateCar(Car car){
        carService.saveCar(car);
        return "redirect:/cars";
    }
}
