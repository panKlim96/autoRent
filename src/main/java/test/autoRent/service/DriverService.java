package test.autoRent.service;

import test.autoRent.model.Driver;

import java.util.List;

public interface DriverService {

    List<Driver> getAll();

    Driver getById(String id);

    void deleteById(String id);
}
