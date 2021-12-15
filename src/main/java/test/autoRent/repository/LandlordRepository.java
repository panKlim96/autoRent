package test.autoRent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import test.autoRent.model.Landlord;

@EnableSwagger2
@Repository
public interface LandlordRepository extends JpaRepository<Landlord, Long> {
    Landlord findById(String id);
}
