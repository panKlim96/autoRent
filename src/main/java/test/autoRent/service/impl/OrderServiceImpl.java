package test.autoRent.service.impl;

import org.springframework.stereotype.Service;
import test.autoRent.model.Order;
import test.autoRent.service.OrderService;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public List<Order> getAll() {
        return null;
    }

    @Override
    public Order getById(String id) {
        return null;
    }

    @Override
    public boolean removeCar(String id) {
        return false;
    }
}
