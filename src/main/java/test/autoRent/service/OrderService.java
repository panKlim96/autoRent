package test.autoRent.service;

import test.autoRent.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAll();

    Order getById(String id);

    boolean removeCar(String id);
}
