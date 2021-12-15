package test.autoRent.service;

import test.autoRent.model.Landlord;

import java.util.List;

public interface LandlordService {
    Landlord register(Landlord driver);

    List<Landlord> getAll();

    Landlord getById(String id);

    boolean removeCar(String id);
}
