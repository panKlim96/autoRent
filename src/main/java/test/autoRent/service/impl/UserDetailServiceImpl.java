package test.autoRent.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import test.autoRent.model.Driver;
import test.autoRent.repository.DriverRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {


    @Autowired
    private DriverRepository driverRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Driver driver = driverRepository.findByUserName(userName).orElseThrow(()-> new UsernameNotFoundException("User with user name:"
        + userName + "not found"));

        return UserDetailsImpl.build(driver);
    }
}
