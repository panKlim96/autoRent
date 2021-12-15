package test.autoRent.service.impl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import test.autoRent.model.Driver;
import java.util.Collection;

@Data
public class UserDetailsImpl implements UserDetails {

    private Long id;
    private String userName;

    public UserDetailsImpl(Long id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    @JsonIgnore
    private String password;

    public static UserDetailsImpl build(Driver driver) {

        return new UserDetailsImpl(
                driver.getId(),
                driver.getUserName(),
                driver.getPassword()
                );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
