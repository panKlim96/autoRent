package test.autoRent.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import test.autoRent.model.Driver;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DriverDto {
        private Long id;
        private String name;
        private String category;

        public Driver toUser(){
            Driver driver = new Driver();
            driver.setId(id);
            driver.setUserName(name);
            driver.setCategory(category);

            return driver;
        }

        public static DriverDto fromUser(Driver driver) {
            DriverDto driverDto = new DriverDto();
            driverDto.setId(driver.getId());
            driverDto.setName(driver.getUserName());
            driverDto.setCategory(driver.getCategory());

            return driverDto;
        }
}
