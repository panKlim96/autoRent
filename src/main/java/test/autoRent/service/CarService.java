package test.autoRent.service;

import test.autoRent.model.Car;

import java.util.List;


public interface CarService {
    List<Car> getAll();

    Car getById(String id);

    boolean removeCar(String id);
}
