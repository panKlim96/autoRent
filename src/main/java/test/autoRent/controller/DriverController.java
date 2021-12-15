package test.autoRent.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import test.autoRent.model.Driver;
import test.autoRent.service.DriverService;

import java.util.List;

@RestController
@RequestMapping("driver")
@AllArgsConstructor
public class DriverController {
    @Autowired
    final DriverService driverService;

    @GetMapping("/getDriver")
    public Driver geDriver(@RequestParam String id) {
        return driverService.getById(id);
    }

    @GetMapping("/getAllDrivers")
    public List<Driver> geAllDrivers() {
        return driverService.getAll();
    }

    @PostMapping
    public void updateDriver(){

    }

    @DeleteMapping("deleteDriver")
    public void deleteDriver(@RequestParam String id){
        driverService.deleteById(id);
    }
}
