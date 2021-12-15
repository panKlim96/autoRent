package test.autoRent.security;

import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class JwtUtils {
    @Value("${app.jwtSecret}")
    private String jwtSecret;

    @Autowired
    private Map<String, String> tokenUserMap;

    private static int count = 0;
    public String generateJwtToken(Authentication authentication) {
        count++;
        tokenUserMap.put("TOKEN" + count, authentication.getName());
        return "TOKEN" + count;
    }

    public boolean validateJwtToken(String jwt) {
        return tokenUserMap.containsKey(jwt);
    }


    public String getUserNameFromJwtToken(String jwt) {
        return tokenUserMap.get(jwt);
    }
}
