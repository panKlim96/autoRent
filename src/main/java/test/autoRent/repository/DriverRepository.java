package test.autoRent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import test.autoRent.model.Driver;

import java.util.List;
import java.util.Optional;

@EnableSwagger2
@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
    Optional<Driver> findByUserName(String userName);
    Optional<Driver> findById(Long id);
    List<Driver> findAll();
    Boolean existsByUserName(String Username);
}
