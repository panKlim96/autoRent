package test.autoRent.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.autoRent.model.Driver;
import test.autoRent.repository.DriverRepository;
import test.autoRent.service.DriverService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class DriverServiceImpl implements DriverService {
    @Autowired
    final private DriverRepository driverRepository;

    @Override
    public List<Driver> getAll() {
        List<Driver> result = driverRepository.findAll();
        log.info("IN getAll - {} driver found", result.size());
        return result;
    }

    @Override
    public Driver getById(String id) {
        Optional<Driver> driver = driverRepository.findById(Long.parseLong(id));
        if (driver.get() == null) {
            log.warn("IN findById - no user found by id: {}", id);
            return null;
        }
        log.info("IN getById - driver: {} found by id", driver.get().getUserName());
        return driver.get();
    }

    @Override
    public void deleteById(String id) {
        driverRepository.deleteById(Long.parseLong(id));
        log.info("IN delete - driver with id: {} successfully deleted");
    }
}
