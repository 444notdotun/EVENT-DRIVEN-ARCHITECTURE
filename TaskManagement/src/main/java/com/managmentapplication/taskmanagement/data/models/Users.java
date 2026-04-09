package com.managmentapplication.taskmanagement.data.models;

import com.managmentapplication.taskmanagement.utils.Generator;
import com.managmentapplication.taskmanagement.utils.GeneratorType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Data
public class Users  implements UserDetails {
    @Id
    private String userId;
    @Column(unique = true)
    private String username;
    private String password;
    private String firstNAme;
    private String lastNAme;
    private Role role;

    @PrePersist
    public void prePersist(){
        this.userId = Generator.generate(GeneratorType.USER);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_"+role.name()));
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
