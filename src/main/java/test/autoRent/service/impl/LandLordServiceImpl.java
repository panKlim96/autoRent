package test.autoRent.service.impl;

import org.springframework.stereotype.Service;
import test.autoRent.model.Landlord;
import test.autoRent.service.LandlordService;

import java.util.List;

@Service
public class LandLordServiceImpl implements LandlordService {
    @Override
    public Landlord register(Landlord driver) {
        return null;
    }

    @Override
    public List<Landlord> getAll() {
        return null;
    }

    @Override
    public Landlord getById(String id) {
        return null;
    }

    @Override
    public boolean removeCar(String id) {
        return false;
    }
}
