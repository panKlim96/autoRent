package test.autoRent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.autoRent.dto.JwtResponse;
import test.autoRent.dto.LoginRequestDto;
import test.autoRent.dto.MessageResponse;
import test.autoRent.dto.SignupRequestDio;
import test.autoRent.model.Driver;
import test.autoRent.repository.DriverRepository;
import test.autoRent.security.JwtUtils;
import test.autoRent.service.impl.UserDetailsImpl;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    DriverRepository driverRepository;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/signin")
    public ResponseEntity<?> authUser(@RequestBody LoginRequestDto loginRequest) {

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl driver = (UserDetailsImpl) authentication.getPrincipal();


        return ResponseEntity.ok(new JwtResponse(jwt,
                driver.getId(),
                driver.getUsername()
                ));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequestDio signupRequestDio){

        if (driverRepository.existsByUserName(signupRequestDio.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is exist"));
        }


        Driver driver = new Driver(signupRequestDio.getUsername(),
                passwordEncoder.encode(signupRequestDio.getPassword()));


        driverRepository.save(driver);
        return ResponseEntity.ok(new MessageResponse("User CREATED"));
    }
}
