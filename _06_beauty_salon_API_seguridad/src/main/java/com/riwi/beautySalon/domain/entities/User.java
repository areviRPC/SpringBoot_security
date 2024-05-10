package com.riwi.beautySalon.domain.entities;



import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.riwi.beautySalon.utils.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 6
@Entity(name = "users")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails{ // 7
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(length = 150 , nullable = false, unique = true)
    private String userName;
    @Column(length = 150 , nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role; //6.1
    @Override


    public Collection<? extends GrantedAuthority> getAuthorities() { // 7.6 quien pone autoridad?
        return List.of(new SimpleGrantedAuthority(this.role.name()));
    }
    @Override
    public String getUsername(){ // 7.1
       return this.userName;
    }
    @Override
    public boolean isAccountNonExpired(){ //7.2 
        return true;
    }
    @Override
    public boolean isAccountNonLocked() { // 7.3
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() { // 7.4
        return true;
    }
    @Override
    public boolean isEnabled() { // 7.5
        return true;
    }
}
