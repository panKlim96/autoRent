package test.autoRent.service.impl;

import org.springframework.stereotype.Service;
import test.autoRent.model.Car;
import test.autoRent.service.CarService;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Override
    public List<Car> getAll() {
        return null;
    }

    @Override
    public Car getById(String id) {
        return null;
    }

    @Override
    public boolean removeCar(String id) {
        return false;
    }
}
